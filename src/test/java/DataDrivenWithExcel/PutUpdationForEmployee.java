package DataDrivenWithExcelTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class PutUpdationForEmployee {

    @Test(dataProvider = "Employeedataprovider")
    public void PUTEmployeeId(String EMPNAME, String EMPSAL, String EMPAGE, String EID) throws InterruptedException, IOException {

        String path = System.getProperty("user.dir") + "/src/test/java/DataDrivenWithExcel/empData.xlsx";
        String sheetName = "Sheet1";

        int totalRows = XLUtils.getRowCount(path, sheetName);
        String oldName = "", oldSalary = "", oldAge = "";
        boolean found = false;

        for (int i = 1; i <= totalRows; i++) {
            String excelID = XLUtils.getCellData(path, sheetName, i, 3);
            if (excelID.equals(EID)) {
                oldName = XLUtils.getCellData(path, sheetName, i, 0);
                oldSalary = XLUtils.getCellData(path, sheetName, i, 1);
                oldAge = XLUtils.getCellData(path, sheetName, i, 2);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Employee ID " + EID + " not found in Excel!");
            return;
        }

        System.out.println("\n====================================");
        System.out.println("Employee ID: " + EID);
        System.out.println("🔹 Old Data => Name: " + oldName + ", Salary: " + oldSalary + ", Age: " + oldAge);

        // ✅ Generate dynamic changes for every execution
        Random random = new Random();
        String newName = EMPNAME + "_" + (char) ('A' + random.nextInt(26)); // random char suffix
        int newSalary = Integer.parseInt(EMPSAL) + random.nextInt(5000);    // + random value
        int newAge = Integer.parseInt(EMPAGE) + random.nextInt(3);          // + random 0-2 years

        System.out.println("🔹 New Data => Name: " + newName + ", Salary: " + newSalary + ", Age: " + newAge);

        // ✅ Create JSON body
        JSONObject jo = new JSONObject();
        jo.put("name", newName);
        jo.put("salary", String.valueOf(newSalary));
        jo.put("age", String.valueOf(newAge));

        // ✅ REST Assured Request
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
        RequestSpecification req = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(jo.toJSONString());

        Response response = req.request(Method.PUT, "/update/" + EID);
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        if (statusCode == 429) {
            System.out.println("⚠ Too Many Requests - Skipping Update");
            return;
        }

        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response Body: " + responseBody);
        Assert.assertEquals(statusCode, 200, "Unexpected status code for PUT!");

        // ✅ Update Excel file with new data
        for (int i = 1; i <= totalRows; i++) {
            String excelID = XLUtils.getCellData(path, sheetName, i, 3);
            if (excelID.equals(EID)) {
                XLUtils.setCellData(path, sheetName, i, 0, newName);
                XLUtils.setCellData(path, sheetName, i, 1, String.valueOf(newSalary));
                XLUtils.setCellData(path, sheetName, i, 2, String.valueOf(newAge));
                XLUtils.setCellData(path, sheetName, i, 4, "Updated ✅");
                System.out.println("✅ Excel Updated Successfully for ID: " + EID);
                break;
            }
        }

        // ✅ Display before-after difference
        System.out.println("🟩 Before => " + oldName + " | " + oldSalary + " | " + oldAge);
        System.out.println("🟦 After  => " + newName + " | " + newSalary + " | " + newAge);
        System.out.println("====================================");

        Thread.sleep(1000);
    }

    @DataProvider(name = "Employeedataprovider")
    public String[][] getEmployeeData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/DataDrivenWithExcel/empData.xlsx";
        int totalRows = XLUtils.getRowCount(path, "Sheet1");
        int totalCols = 4; // only first 4 columns (name, salary, age, id)

        String empdata[][] = new String[totalRows][totalCols];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return empdata;
    }
}
