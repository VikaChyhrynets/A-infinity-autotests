package api.models;

import io.qameta.allure.Allure;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import lombok.extern.slf4j.Slf4j;
import utils.AllureHelper;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.http.HttpHeaders.AUTHORIZATION;
import static utils.JsonUtil.beautifyString;

@Slf4j
public class RestAssuredRequestFilter implements Filter {
    private final int expectedStatus;

    public RestAssuredRequestFilter(int expectedStatus) {
        this.expectedStatus = expectedStatus;
    }

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        List<Header> requestHeaders = requestSpec.getHeaders().asList().stream()
                .map(header -> {
                    if (header.getName().equals(AUTHORIZATION)) {
                        return new Header(AUTHORIZATION, "Mocked");
                    }
                    return header;
                }).collect(Collectors.toList());

        if (response.statusCode() != this.expectedStatus) {
            log.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
                    response.getStatusCode() + " " + response.getStatusLine());
        }

        StringBuilder logMessage = new StringBuilder();
        logMessage.append("\n ========================== Request ==========================")
                .append("\n Request Method => ").append(requestSpec.getMethod())
                .append("\n Request URL => ").append(requestSpec.getURI());
        if (requestSpec.getBody() != null) {
            logMessage.append(" \n Request Body => ").append(beautifyString(requestSpec.getBody().toString()));
        }
        logMessage.append(" \n Request Headers => ").append(requestHeaders);
        if (requestSpec.getQueryParams() != null)
            logMessage.append(" \n Request Query parameters => ").append(requestSpec.getQueryParams());
        logMessage.append("\n ========================== Response ==========================")
                .append(" \n Response Status => ").append(response.getStatusCode()).append(" ").append(response.getStatusLine());
        if (response.getBody() != null)
            logMessage.append(" \n Response Body => ").append(response.getBody().asPrettyString()).append("\n");
        if (Allure.getLifecycle().getCurrentTestCase().isPresent()) {
            AllureHelper.attachTextToReport("request info.txt", logMessage.toString());
        }
        log.info(logMessage.toString());
        return response;
    }
}