package s4OneToOneBi;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String gender;

    private String city;

    @OneToOne
    @JoinColumn(name = "selamm")
    private Citizen citizen;

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
