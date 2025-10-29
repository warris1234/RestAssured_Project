package ComplexRequestPOJO;

public class Detailss {
    private String companyName;
    private String Manager;
    private Address address;

    public Detailss(String companyName,String Manager,Address address)
    {
        this.companyName = companyName;
        this.Manager = Manager;
        this.address =address;
    }

    public String getCompanyName()
    {
        return companyName;
    }
    public String getManager()
    {
        return Manager;
    }
    public Address getAddressaddress()
    {
        return address;
    }
}
