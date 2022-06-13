package apitests;

import api.models.Specifications;
import api.pojoClasses.RegisterPojo;
import api.pojoClasses.SuccessRegisterPojo;
import api.pojoClasses.UserDataPojo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest extends BaseTestAPI {

    private final static String URL = "https://reqres.in/";

    @Test
    public void getUserDataTest() {

        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpec200());
        List<UserDataPojo> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserDataPojo.class);

        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserDataPojo::getAvatar).collect(Collectors.toList());
        List<String> id = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());

        for(int i = 0; i<avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(id.get(i)));
        }
    }

    @Test
    public void successRegistrationTest() {

        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpec200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        RegisterPojo user = new RegisterPojo("eve.holt@reqres.in","pistol");

        SuccessRegisterPojo successRegisterPojo = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegisterPojo.class);

        Assert.assertEquals(id, successRegisterPojo.getId());
        Assert.assertEquals(token, successRegisterPojo.getToken());

    }
}