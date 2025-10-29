package ComplexResuestNestedData;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;

import java.util.List;

public class Courses {

    private List<WebAutomation>webAutomations;
    private List<APIAutomation>aPIAutomations;
    private List<MobileAutomation>mobileAutomations;

    public static class WebAutomation
    {
      private String courseTitle;
      private Integer price;

        public String getCourseTitle() {
            return courseTitle;
        }

        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }
    }

    public List<WebAutomation> getWebAutomations() {
        return webAutomations;
    }

    public void setWebAutomations(List<WebAutomation> webAutomations) {
        this.webAutomations = webAutomations;
    }

    public void setaPIAutomations(List<APIAutomation> aPIAutomations) {
        this.aPIAutomations = aPIAutomations;
    }

    public void setMobileAutomations(List<MobileAutomation> mobileAutomations) {
        this.mobileAutomations = mobileAutomations;
    }

    public List<APIAutomation> getaPIAutomations() {
        return aPIAutomations;
    }

    public List<MobileAutomation> getMobileAutomations() {
        return mobileAutomations;
    }

    public static class APIAutomation
    {
        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        private String courseTitle;
        private Integer price;

        public String getCourseTitle() {
            return courseTitle;
        }

        public Integer getPrice() {
            return price;
        }
    }

    public static class MobileAutomation
    {
        public void setCourseTitle(String courseTitle) {
            this.courseTitle = courseTitle;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        private String courseTitle;
        private Integer price;

        public String getCourseTitle() {
            return courseTitle;
        }

        public Integer getPrice() {
            return price;
        }
    }
}
