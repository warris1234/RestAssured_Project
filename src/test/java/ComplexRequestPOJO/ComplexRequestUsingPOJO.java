package ComplexRequestPOJO;

public class ComplexRequestUsingPOJO {

        private String name;
        private String job;
        private String[] skills;
        private  Details details;
        //Creating constructor
    //We have to pass the variables which we have created in details class, in the preset
        // constructor inside the parameters
  public ComplexRequestUsingPOJO(String name,String job,String[] skills,
                                 String comapnyName,String emailed)
  {
      this.name = name;
      this.job = job;
      this.skills = skills;
      this.details = new Details(comapnyName,emailed);

  }
        //Creating getter method
    public String getName() {
        return name;
    }

    public String getJob()
    {
        return job;
    }
    public String[] getSkills() {
        return skills;
    }

    public Details getDetails() {
        return details;
    }


}
