package ComplexRequestPOJOTest;

public class ComplexRequestUsingPOJOTest {

        private String name;
        private String job;
        private String[] skills;
        private DetailsTest details;
        //Creating constructor
    //We have to pass the variables which we have created in details class, in the preset
        // constructor inside the parameters
  public ComplexRequestUsingPOJOTest(String name, String job, String[] skills,
                                     String comapnyName, String emailed)
  {
      this.name = name;
      this.job = job;
      this.skills = skills;
      this.details = new DetailsTest(comapnyName,emailed);

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

    public DetailsTest getDetails() {
        return details;
    }


}
