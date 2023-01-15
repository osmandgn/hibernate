package s16Practices;

import javax.persistence.*;

@Entity
@Table(name = "doc_tab")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String department;

    public Doctor(String name, String department) {
        this.name = name;
        this.department = department;
    }
    public Doctor(){

    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
