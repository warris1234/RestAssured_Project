package Autentication;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BasicAuthentication extends BaseClass{
    @Test
    public void BasicTestAutentication() {

        int code = RestAssured.given().
                    get("https://postman-echo.com/basic-auth").
                getStatusCode();
        System.out.println("Status code:" +code);
    }
}
