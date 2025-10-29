package AutenticationTest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BasicAuthenticationTest extends BaseClassTest {
    @Test
    public void BasicTestAutentication() {

        int code = RestAssured.given().
                    get("https://postman-echo.com/basic-auth").
                getStatusCode();
        System.out.println("Status code:" +code);
    }
}
