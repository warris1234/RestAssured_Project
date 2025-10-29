package Autentication;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseClass
{
    @BeforeClass
    public void setUp()
    {
      RestAssured.authentication = RestAssured.preemptive().basic("postman","password");
      RestAssured.baseURI= "https://postman-echo.com/basic-auth";

    }
}
