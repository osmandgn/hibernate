package s4OneToOneBi;

import javax.persistence.*;

@Entity
@Table(name = "t_citizen")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "c_name", nullable = false, length = 100)
    private String name;

    @Column(name = "c_surname", nullable = false)
    private String surname;

    @OneToOne(mappedBy = "citizen")
    private Passport passport;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passport=" + passport +
                '}';
    }
}
