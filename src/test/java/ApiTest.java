import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest
{
    @Test
    public void getUserRequest()
    {
        String url = "https://reqres.in/api/users?page=2";
            Response response = get(url);
            System.out.println("Reponse:" +response.asString());
        System.out.println("Reponse:" +response.getStatusCode());
        System.out.println("Reponse:" +response.getBody().asString());
        System.out.println("Reponse:" +response.getTime());
        System.out.println("Reponse:" +response.getHeader("content-type"));
        Assert.assertEquals(response.getStatusCode(),200);
       int total_pages = response.jsonPath().get("total_pages");
       Assert.assertEquals(total_pages,2);
    }

    @Test
    public void ValidateGetUser()
    {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }
}
