package RestAssuredCRUDMethodTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequest
{
        @Test
         public void CreateUser()
         {
             JSONObject jo  = new JSONObject();
             jo.put("id", 3007657 );
             jo.put("first_name", "warris" );
             jo.put("CompanyName", "Equiniti" );
             jo.put("CompanyWise", "Product" );
             jo.put("subjectId", "AutomationTest");

         RequestSpecification req = given();
         req.contentType(ContentType.JSON);
         req.body(jo.toString());

         Response response= req.post("http://localhost:3000/users");
             response.then().log();
         }
}
