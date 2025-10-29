package RestAPITesting;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class RestApiAutomate
{
    @Test()
    public void getUserRequest()
    {
        String url = "https://reqres.in/api/users?page=2";
        Response response = get(url);
        Assert.assertEquals(response.getStatusCode(),200);
        int total_pages = response.jsonPath().get("total_pages");
        Assert.assertEquals(total_pages,2);
    }

// Creating a post request
@Test
public void getPostRequest()
{
    String url = "https://jsonplaceholder.typicode.com/posts";
    String contentType = "application/json";
    String bodyData = """
                {
                  "title": "warris",
                  "body": "learning Rest Assured",
                  "userId": 1
                }
                """;
    Response response = RestAssured.
            given().
            contentType(contentType).
            body(bodyData).
            when().
            post(url).
            then().
            extract().
            response();
    Assert.assertEquals(response.getStatusCode(),201);
    String title = response.jsonPath().getString("title");
    Assert.assertEquals(title, "warris");
    System.out.println("Response Body: " + response.asString());
    Reporter.log("Found Mistach Name!!", true);

}

}
