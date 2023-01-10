package s15EntityLifeCycle;

/*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :
	Entity State :
		*) Transient : The lifecycle state of a newly instantiated entity object is called transient.
		 The entity hasn’t been persisted yet, so it doesn’t represent any database record.

		*) Persisted or Managed : All entity objects attached to the current persistence context are in the lifecycle state managed.
		That means that your persistence provider, e.g. Hibernate, will detect any changes on the objects and generate the required
		SQL INSERT or UPDATE statements when it flushes the persistence context.

		*) Detached : An entity that was previously managed but is no longer attached
		to the current persistence context is in the lifecycle state detached.

		*) Removed : When you call the remove method on your EntityManager,
		the mapped database record doesn’t get removed immediately.
		 The entity object only changes its lifecycle state to removed.
*/

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="student_name", nullable = false)
    private String name;

    private int mathGrade;

    // Getter - Setter ***************************


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    // toString() ************************************************


    @Override
    public String toString() {
        return "Student14{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathGrade=" + mathGrade +
                '}';
    }
}
