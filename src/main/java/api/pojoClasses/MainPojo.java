package api.pojoClasses;

import api.models.RestAssuredRequestFilter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

@Slf4j
public class MainPojo {

        protected RestAssuredConfig config;

        protected Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        public MainPojo() {
            config = RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader(AUTHORIZATION));
        }

        protected Response get(String url, RequestSpecification requestSpec, int expectedStatusCode) {
            return baseMethod(Method.GET, url, requestSpec, expectedStatusCode);
        }

        protected Response post(String url, RequestSpecification requestSpec, int expectedStatusCode) {
            return baseMethod(Method.POST, url, requestSpec, expectedStatusCode);
        }

        protected Response put(String url, RequestSpecification requestSpec, int expectedStatusCode) {
            return baseMethod(Method.PUT, url, requestSpec, expectedStatusCode);
        }

        protected Response delete(String url, RequestSpecification requestSpec, int expectedStatusCode) {
            return baseMethod(Method.DELETE, url, requestSpec, expectedStatusCode);
        }

        private Response baseMethod(Method method, String url, RequestSpecification requestSpec, int expectedStatusCode) {
            requestSpec.contentType(ContentType.JSON).config(config);
            Response response = given()
                    .filter(new RestAssuredRequestFilter(expectedStatusCode))
                    .spec(requestSpec)
                    .log().ifValidationFails()
                    .when()
                    .request(method, url);
            return response.then()
                    .log().ifValidationFails()
                    .statusCode(expectedStatusCode)
                    .extract()
                    .response();
        }
}