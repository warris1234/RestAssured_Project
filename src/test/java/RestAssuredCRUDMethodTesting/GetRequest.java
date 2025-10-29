package RestAssuredCRUDMethodTesting;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class GetRequest
{
    @Test
    public void GetUser()
    {
        Response response= get("http://localhost:3000/users");
        // printing the reponse in different ways
//       response.prettyPrint();
//        System.out.println("Reponse:" +response.getStatusCode());
//        System.out.println("Reponse:" +response.getBody().asString());
//        System.out.println("Reponse:" +response.getTime());
//        System.out.println("Reponse:" +response.getHeader("content-type"));
//        Assert.assertEquals(response.getStatusCode(),200);

        //validation
        ValidatableResponse val = response.then();
        val.assertThat().statusCode(200);
        val.assertThat().contentType(ContentType.JSON);

        val.log().all();




    }
}
