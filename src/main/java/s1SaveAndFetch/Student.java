package s1SaveAndFetch;

import javax.persistence.*;

@Table(name = "sdt")
@Entity
public class Student {

    @Id
    @Column(name = "sdt_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sq_gn", initialValue = 0)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;
    private String surname;


    private String address;

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String toString(){
        return "Id: " + id + " Name: " + name + " Surname: " + surname + " Address: " + address;
    }

}
