package ComplexRequestPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostApiUsingPojo
{
    public static void main(String [] args)
    {
        ComplexRequestUsingPOJO cp = new ComplexRequestUsingPOJO("warris","automation",
                new String[] {"java","c"},"equiniti",
                "warris@outlook.com");


        Response response = RestAssured.given().
                auth().
                none().
                header("ContentType","application/json").
                contentType(ContentType.JSON).
                body(cp).
                when().
                log().
                all().
                post("https://postman-echo.com/post");

        System.out.println(response.getStatusCode());
        System.out.println(response.body().toString());
        System.out.println(response.asString());
    }




}
