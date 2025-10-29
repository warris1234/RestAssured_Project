package ComplexRequestPOJO;

public class Details {

    private String comapnyName;
    private String emailed;


    //creating constructor
    public Details(String comapnyName,String emailed) {
        //we are using the current class constructor variable with the help of this keyword
        this.comapnyName = comapnyName;
        this.emailed = emailed;
    }

    public String getEmailed() {
        return emailed;
    }

    public void setEmailed(String emailed) {
        this.emailed = emailed;
    }
}
