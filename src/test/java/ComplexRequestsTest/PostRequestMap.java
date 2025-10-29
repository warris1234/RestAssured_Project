package ComplexRequestsTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class PostRequestMap
{
    public static void main(String[] args)
    {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","Rahul");
        ArrayList<String> li = new ArrayList<>();
        li.add("Java");
        li.add("Python");
        li.add("API Testing");
        map.put("skills",li);

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
