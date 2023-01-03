package s5ManyToOneUni;

import javax.persistence.*;

@Entity
public class University {

    @Id
    @Column(name = "uni_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uni_gen")
    @SequenceGenerator(name = "uni_gen", sequenceName = "uni_seq")
    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
