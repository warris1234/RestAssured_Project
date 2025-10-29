package ComplexResuestNestedDataTest;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ComplexRequestTest {

    public static void main(String[] args)
    {

       List<CoursesTest.WebAutomation> web = new ArrayList<>();
       CoursesTest.WebAutomation sel = new CoursesTest.WebAutomation();
       sel.setCourseTitle("selenium");
       sel.setPrice(4000);
        CoursesTest.WebAutomation pro = new CoursesTest.WebAutomation();
        pro.setCourseTitle("Cloud");
        pro.setPrice(400);
        web.add(sel);
        web.add(pro);
        List<CoursesTest.APIAutomation> api = new ArrayList<>();
        CoursesTest.APIAutomation apl = new CoursesTest.APIAutomation();
        apl.setCourseTitle("RestAssured");
        apl.setPrice(500);
        CoursesTest.APIAutomation apls = new CoursesTest.APIAutomation();
        apls.setCourseTitle("Soap API");
        apls.setPrice(7000);
        api.add(apl);
        api.add(apls);
        List<CoursesTest.MobileAutomation> appium = new ArrayList<>();
        CoursesTest.MobileAutomation ap = new CoursesTest.MobileAutomation();
        ap.setCourseTitle("appium");
        ap.setPrice(9000);
        appium.add(ap);

        CoursesTest cs = new CoursesTest();
        cs.setWebAutomations(web);
        cs.setaPIAutomations(api);
        cs.setMobileAutomations(appium);
        ComplexUsingNestedJsonTest cu = new ComplexUsingNestedJsonTest();
        cu.setInstructor("Warris");
        cu.setInstructor("softwaretesting.com");
        cu.setServices("software testing");
        cu.setUrl("Testing");
        cu.setCourses(cs);
        cu.setLinkedin("LinkedIn");


    }
}
