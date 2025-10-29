package ComplexRequestPOJO;

public class EmployeeNewDataComplexRequest {
    private String name;
    private String job;
    private String[] skills;
    private Detailss detailss;
    private Address address;

    //creating constructor
   public EmployeeNewDataComplexRequest(String name,String job,String[] skills,
                                        String companyName,String Manager,String city,String pincode)
   {
       this.name = name;
       this.job = job;
       this.skills = skills;
       // create nested structure properly
       Address address = new Address(city, pincode);
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





