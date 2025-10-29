package ComplexRequestPOJOTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APITesingUsingThirdObjectTest {
    public static void main(String [] args)
    {
        EmployeeNewDataComplexRequestTest ed = new EmployeeNewDataComplexRequestTest
                ("warris","Automation Test Engineer",new String[] {"java","restAssured"},
                        "Virtusa","Sonai","Bangalore",
                        "500008");

        Response response = RestAssured.given().
                auth().
                none().
                header("ContentType","application/json").
                contentType(ContentType.JSON).
                body(ed).
                when().
                log().
                all().
                post("https://postman-echo.com/post");

        System.out.println(response.getStatusCode());
        System.out.println(response.body().toString());
        System.out.println(response.asString());
    }

    }

