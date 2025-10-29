package ComplexRequestPOJOTest;

public class Detailss {
    private String companyName;
    private String Manager;
    private AddressTest address;

    public Detailss(String companyName, String Manager, AddressTest address)
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
    public AddressTest getAddressaddress()
    {
        return address;
    }
}
