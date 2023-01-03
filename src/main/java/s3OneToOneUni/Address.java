package s3OneToOneUni;

import javax.persistence.*;

@Table(name = "t_address")
@Entity
public class Address {

    @Id
    @Column(name = "add_id", length = 100, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "zip", length = 100, nullable = false)
    private String zipCode;


    private String street;

    public int getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
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
                "id=" + id +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
