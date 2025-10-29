package RestAssuredCRUDMethodTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchUpadation
{
    @Test
    public void UpdationExistingUser()
    {
        JSONObject jo = new JSONObject();
        jo.put("Project","HSBC");
        jo.put("LeadAutomation","Sonai Raja");
        jo.put("Manager","Balaji Murugun");
        RequestSpecification req=  given();
        req.contentType(ContentType.JSON);
        req.body(jo.toString());
        // Send PATCH request
        Response response =  req.patch("http://localhost:3000/users/3007657");
        // Log response
        response.then().log().all();
        int code =response.getStatusCode();
        Assert.assertTrue(code == 200|| code == 201,"Unexpected code:" +code);
        String statusLine =   response.getStatusLine();
        Assert.assertTrue(
                statusLine.equals("HTTP/1.1 200 OK") || statusLine.equals("HTTP/1.1 201 Created "),
                "Unexpected Status Line: " + statusLine);
    }
}

