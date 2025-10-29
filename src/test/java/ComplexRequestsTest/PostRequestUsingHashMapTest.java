package ComplexRequestsTest;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class PostRequestUsingHashMapTest {
    public static void main(String[] args) {



        //Create main map
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "warris");
        map.put("job", "AutomationTester");

        // Add array of skills
        ArrayList<String> al = new ArrayList<>();
        al.add("java");
        al.add("javaScript");
        map.put("skills", al);

        // Add nested object for details
        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("CompanyName", "Equiniti");
        map1.put("email", "warris@outlook.com");
        map.put("details", map1);



        // Send POST request to Postman Echo (or any endpoint that accepts complex JSON)
        Response response = given().
                 auth()
                .none()
                .header("ContentType","application/json")
                .contentType(ContentType.JSON)
                .when()
                .body(map)
                .log().all()
                .post("https://postman-echo.com/post");

        // Print response
        System.out.println("Response: " + response.asString());
        System.out.println("Status Code: " + response.getStatusCode());
    }
}
