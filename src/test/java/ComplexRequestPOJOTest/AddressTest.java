package ComplexRequestPOJOTest;

public class AddressTest {
    private String city;
    private String pincode;


    public AddressTest(String city, String pincode)
    {
        this.city = city;
        this.pincode = pincode;
    }

    public String getCity()
    {
        return city;
    }

    public String getPincode()
    {
        return pincode;
    }


}
