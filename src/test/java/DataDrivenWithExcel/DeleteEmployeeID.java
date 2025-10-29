package DataDrivenWithExcelTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteEmployeeID
{

    @Test(dataProvider = "deleteData")
    public void DeleteEmployeeId(String EMPNAME, String EMPSAL, String EMPAGE,String EID) throws InterruptedException {
        // Base URI
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

        // Request specification
        RequestSpecification req = RestAssured.given();


        // Delete Request
        Response response = req.request(Method.DELETE, "/delete/" + EID);

        int statusCode = response.getStatusCode();
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());


        if (statusCode == 429) {
            System.out.println("⚠ Too Many Requests - Skipping Assertions");
            return; // skip the rest to avoid test failure
        }
        System.out.println("Deleting employee ID: " +EID);

        Thread.sleep(2000); // avoid rate limit


    }


    @DataProvider(name = "deleteData")
    public Object[][] geData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/DataDrivenWithExcel/empData.xlsx";
        String sheetName = "Sheet1";
        return XLUtils.getExcelData(path, sheetName);

    }
}


