package ComplexRequestPOJOTest;

public class EmployeeNewDataComplexRequestTest {
    private String name;
    private String job;
    private String[] skills;
    private Detailss detailss;
    private AddressTest address;

    //creating constructor
   public EmployeeNewDataComplexRequestTest(String name, String job, String[] skills,
                                            String companyName, String Manager, String city, String pincode)
   {
       this.name = name;
       this.job = job;
       this.skills = skills;
       // create nested structure properly
       AddressTest address = new AddressTest(city, pincode);
       this.detailss = new Detailss(companyName,Manager,address);



   }
//creating getter method
    public String getName()
    {
        return name;
    }
  public String getJob()
    {
     return job;
    }
  public String[] getSkills()
    {
    return skills;
    }
    public Detailss getDetailss()
    {
        return detailss;
    }
}





