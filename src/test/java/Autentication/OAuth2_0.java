package Autentication;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OAuth2_0 {
    //We are currently following a manual approach by copying the token from an external site and pasting it into our code. This is not a good practice, as it isn’t truly automated.

    @Test
    public void Oauth2() {
        Response response = RestAssured
                .given()
                .auth()
                .oauth2("77488bde706301832c1f4795d2b951e3b47493be")
                .post("http://coop.apps.symfonycasts.com/api/4413/barn-unlock");

        // ✅ Print status code
        System.out.println("Status Code: " + response.getStatusCode());

        // ✅ Print readable response bodyZ
        System.out.println("Response Body: " + response.getBody().asString());

        // ✅ Optional: assert success
        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 but got different status");
    }
}
