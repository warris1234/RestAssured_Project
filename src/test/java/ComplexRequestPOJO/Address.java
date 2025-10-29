package ComplexRequestPOJO;

public class Address {
    private String city;
    private String pincode;


    public Address(String city,String pincode)
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
