package s2Embeddable;

import javax.persistence.*;

@Embeddable
public class Address {


    private String zipCode;

    private String street;

    private String city;


    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
