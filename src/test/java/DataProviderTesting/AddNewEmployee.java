package DataProviderTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddNewEmployee {

    @Test(dataProvider = "Employeedataprovider")
    void postNewEmployee(String ename,String esalary,String eage) throws InterruptedException {
        // Base URI
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        // Request specification
        RequestSpecification req = RestAssured.given();

        // JSON Object for request body
        JSONObject jo = new JSONObject();
        jo.put("name", ename);
        jo.put("salary", esalary);
        jo.put("age", eage);

        // Headers and body
        req.header("Content-Type", "application/json");
        req.contentType(ContentType.JSON);
        req.body(jo.toJSONString());

        // POST Request
        Response response = req.request(Method.POST, "/create");

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        if (statusCode == 429) {
            System.out.println("⚠ Too Many Requests - Skipping Assertions");
            return; // skip the rest to avoid test failure
        }

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

// Assertions
        Assert.assertTrue(responseBody.contains(ename), "Name not found in response!");
        Assert.assertTrue(responseBody.contains(esalary), "Salary not found in response!");
        Assert.assertTrue(responseBody.contains(eage), "Age not found in response!");
        Assert.assertEquals(statusCode, 200, "Unexpected status code!");

        Thread.sleep(2000); // avoid rate limit

    }


    @DataProvider(name = "Employeedataprovider")
    String[][] getEmployeeData() {
        String empData[][] = {{"Test2","79000","27"},{"Test3","34000","32"},{"Azad","76000","33"},{"Ars","62222","23"},{"Warris","7000","47"}};
        return (empData);
    }
    }
