package s5ManyToOneUni;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sdt_gen")
    @SequenceGenerator(name = "sdt_gen", sequenceName = "sdt_seq")
    private int id;

    private String name;


    private String surname;

    @ManyToOne
    @JoinColumn(name = "uni_id")
    private University university;

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

    private LocalDate createOn;
    @PrePersist
    public void prePersist(){
        createOn = LocalDate.now();
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", university=" + university +
                '}';
    }
}
