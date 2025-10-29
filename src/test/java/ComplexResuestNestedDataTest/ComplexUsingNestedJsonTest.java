package ComplexResuestNestedDataTest;

public class ComplexUsingNestedJsonTest {

    private String instructor;
    private String url;
    private String services;
     private String expertise;
    private CoursesTest courses;
    private String Linkedin;

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public void setCourses(CoursesTest courses) {
        this.courses = courses;
    }

    public void setLinkedin(String linkedin) {
        Linkedin = linkedin;
    }

    public String getUrl() {
        return url;
    }

    public String getServices() {
        return services;
    }

    public String getExpertise() {
        return expertise;
    }

    public CoursesTest getCourses() {
        return courses;
    }

    public String getLinkedin() {
        return Linkedin;
    }
}
