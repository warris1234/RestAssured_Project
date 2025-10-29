package RestAssuredCRUDMethodTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest
{
     @Test
     public void DeleteUser()
    {
            RequestSpecification Reqres=  given();
            Reqres.contentType(ContentType.JSON);
        // Send DELETE request
            Response response =  Reqres.delete("http://localhost:3000/users/8156339");
        // Log all response details
            response.then().log().all();
        // Validate status code
        int code = response.getStatusCode();
        Assert.assertTrue(code == 200 || code == 204, "Unexpected Status Code: " + code);

        // Validate status line
        String statusLine = response.getStatusLine();
        Assert.assertTrue(
                statusLine.equals("HTTP/1.1 200 OK") || statusLine.equals("HTTP/1.1 204 No Content"),
                "Unexpected Status Line: " + statusLine);

    }
    }

