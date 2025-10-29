package ComplexRequestsTest;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

public class PostRequestHashMap
{
    public static void main(String[] args)
    {
        HashMap<String,Object> map  = new HashMap<>();

    map.put("name","Arshiya");
    map.put("job", "Associate Engineer");

        Response response=  given().
                auth().
                none().
                header("ContentType","application/json").
                contentType(ContentType.JSON).
                when().
                body(map).
                log().
                all().
               post("https://postman-echo.com/post");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().toString());
        response.prettyPrint();
}
}
