package s14Get_Load_Methods;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_gen")
    @SequenceGenerator(name = "sq_name", sequenceName = "sequence", initialValue = 1000, allocationSize = 2)
    private long id;

    @Column(name = "employee_name", nullable = false)
    private String name;

    public long getId() {
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
        return "EmployeeFetcher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
