package se.iths.complexjavaproject.jms.model;

public class MessageCustomer {

    private String name;
    private String street;
    private String postalCode;
    private String city;

    public MessageCustomer(String name, String street, String postalCode, String city) {
        this.name = name;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public MessageCustomer() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }


}
