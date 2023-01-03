package s08Practice;

//Utıls
// Constructor
// onetoone ikisinde de tablo

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Passport {

    @Id
    private int id;

    private String serialNo;

    @OneToOne
    private Citizen citizen;

    public Passport(){

    }

    public Passport(int id, String serialNo) {
        this.id = id;
        this.serialNo = serialNo;
        this.citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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
                ", serialNo='" + serialNo + '\'' +
                '}';
    }

}
