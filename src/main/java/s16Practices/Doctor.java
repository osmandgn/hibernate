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

    public Doctor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    public Doctor(){

    }
}
