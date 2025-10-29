package ComplexRequestJsonObjectTest;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ComplexReuestUsingJsonObjectTest
{

    public static void main(String[] args) {
        // Create main JSON object
        JSONObject jo = new JSONObject();
        jo.put("name", "warris");
        jo.put("job", "Automation");

        // Create skills array
        JSONArray ja = new JSONArray();
        ja.add("Java");
        ja.add("APITesting");
        jo.put("skills", ja);

        // Create nested details object
        JSONObject jo1 = new JSONObject();
        jo1.put("companyName", "Equiniti");
        jo1.put("email", "warris@outlook.com");
        jo.put("details", jo1);

        // Send POST request
        Response response = given()
                .auth().none()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(jo.toString())
                .when()
                .log().all()
                .post("https://postman-echo.com/post");

        // Print results
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.getBody().toString());
        System.out.println("Response: " + response.asPrettyString());
    }
}

