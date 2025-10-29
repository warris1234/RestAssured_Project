package ComplexRequestsTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class PostRequestForDifferentData
{
    public static void main(String[] args)
    {
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("moduleName","Login");
        map1.put("status","Completed");


        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("moduleName","Signup");
        map2.put("status","Pending");

        ArrayList<Object> al = new ArrayList<>();
        //ArrayList<HashMap<String, Object>> al = new ArrayList<>();
        al.add(map1);
        al.add(map2);
        HashMap<String,Object> map3 = new HashMap<>();
        map3.put("projectName","AutomationSuite");
        map3.put("modules",al);




        Response response = RestAssured.given().
                auth().
                none().
                header("ContentType","application/json").
                contentType(ContentType.JSON).
                body(map3).
                when().
                log().
                all().
                post("https://postman-echo.com/post");

        System.out.println(response.getStatusCode());
        System.out.println(response.body().toString());
        System.out.println(response.asString());

    }
}
