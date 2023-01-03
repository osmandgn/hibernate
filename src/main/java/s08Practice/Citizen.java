package s08Practice;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Citizen {

    @Id
    private int id;

    private String name;

    private String surname;

    @OneToOne
    private Passport passport;

    public Citizen(){

    }

    public Citizen(int id, String name, String surname, Passport passport) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
