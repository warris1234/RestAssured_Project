package ComplexRequestsTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class PostRequestTest {
    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        map.put("name","warris");
        map.put("job","Leader");

        ArrayList<String> al = new ArrayList<>();
        al.add("Java");
        al.add("JavaScript");
        map.put("skills",al);

        Map<String,Object> map1 = new HashMap<>();
        map1.put("companyName","Equiniti");
        map1.put("email","warris@outlook.co");
        map.put("details",map1);


        Map<String,Object> map2 = new HashMap<>();
        map2.put("city","Guwahati");
        map2.put("pincode","845426");
        map.put("address",map2);

        Response response = given()
                .auth().none()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .body(map)
                .log().all()
                .post("https://postman-echo.com/post");

        // 6️⃣ Print response
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asPrettyString());
    }
}
