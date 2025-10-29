package ComplexRequestsTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

public class PostRequestMapTest
{
    public static void main(String[] args)
    {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","Kiran");
        map.put("age","28");
        map.put("department","QA");
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("employee",map);

        Response response = RestAssured.given().
                auth().
                none().
                header("ContentType","application/json").
                contentType(ContentType.JSON).
                body(map).
                when().
                log().
                all().
                post("https://postman-echo.com/post");

        System.out.println(response.getStatusCode());
        System.out.println(response.body().toString());
        System.out.println(response.asString());


    }
}
