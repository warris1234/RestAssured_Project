package RestAssuredCRUDMethodTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequests {


    @Test
    public void CreateUser()
    {
        JSONObject jo = new JSONObject();
        {
            jo.put("id", 8156339);
            jo.put("CompanyName", "Virtusa");
            jo.put("Location", "Bangalore");
            jo.put("Project", "OBU_BCP");
            jo.put("Client", "AstraZeneca");
            jo.put("Manager_Virtusa", "Vivek");
            jo.put("Client_Manager", "Brentan");
            jo.put("Role", "Automation Test Engineer");

         RequestSpecification Reqres=  given();
                    Reqres.contentType(ContentType.JSON);
                    Reqres.body(jo.toString());
               Response response =  Reqres.post("http://localhost:3000/users");
               response.then().log().all();


            Assert.assertEquals(response.getStatusCode(),201);
           String CompanyName = response.jsonPath().get("CompanyName");
            Assert.assertEquals(CompanyName,"Virtusa");
           int id = response.jsonPath().get("id");
            long responseTime = response.getTime();
            Assert.assertTrue(responseTime < 1000, "Response time is too high: " + responseTime);


        }
    }
}
