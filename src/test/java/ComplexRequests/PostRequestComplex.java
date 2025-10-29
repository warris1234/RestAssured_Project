package ComplexRequests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRequestComplex {
    public static void main(String[] args)
    {
        HashMap<String,Object> map = new HashMap<>();
        map.put("deptName","Development");

        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("name","Ravi");
        map1.put("role","Backend Dev");
        map1.put("name","Anjali");
        map1.put("role","Frontend Dev");

        ArrayList<String> al = new ArrayList<>();
        map1.put("employees",al);




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
