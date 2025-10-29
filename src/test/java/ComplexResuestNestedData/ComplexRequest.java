package ComplexResuestNestedData;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ComplexRequest {

    public static void main(String[] args)
    {

       List<Courses.WebAutomation> web = new ArrayList<>();
       Courses.WebAutomation sel = new Courses.WebAutomation();
       sel.setCourseTitle("selenium");
       sel.setPrice(4000);
        Courses.WebAutomation pro = new Courses.WebAutomation();
        pro.setCourseTitle("Cloud");
        pro.setPrice(400);
        web.add(sel);
        web.add(pro);
        List<Courses.APIAutomation> api = new ArrayList<>();
        Courses.APIAutomation apl = new Courses.APIAutomation();
        apl.setCourseTitle("RestAssured");
        apl.setPrice(500);
        Courses.APIAutomation apls = new Courses.APIAutomation();
        apls.setCourseTitle("Soap API");
        apls.setPrice(7000);
        api.add(apl);
        api.add(apls);
        List<Courses.MobileAutomation> appium = new ArrayList<>();
        Courses.MobileAutomation ap = new Courses.MobileAutomation();
        ap.setCourseTitle("appium");
        ap.setPrice(9000);
        appium.add(ap);

        Courses cs = new Courses();
        cs.setWebAutomations(web);
        cs.setaPIAutomations(api);
        cs.setMobileAutomations(appium);
        ComplexUsingNestedJson cu = new ComplexUsingNestedJson();
        cu.setInstructor("Warris");
        cu.setInstructor("softwaretesting.com");
        cu.setServices("software testing");
        cu.setUrl("Testing");
        cu.setCourses(cs);
        cu.setLinkedin("LinkedIn");


    }
}
