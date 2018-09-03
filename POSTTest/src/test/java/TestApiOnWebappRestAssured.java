

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestApiOnWebappRestAssured {

@Test
    public void restTest() {

    RestAssured.baseURI = "http://instatestvx.me";
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    JsonObject loginCredentials = new JsonObject();
    loginCredentials.addProperty("email", "hello@world.com");
    loginCredentials.addProperty("password", "12345678");
    httpRequest.body(loginCredentials.toString());
    Response response = httpRequest.post("/api/auth/login");

    String messageResponse = response.path("message");

    Assert.assertEquals(messageResponse,  "The password and email you entered don't match. If you forgot your password, use \"Forgot Password\"" );
    }
}
