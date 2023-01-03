package s10ManyToManyBi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int id;

    private String name;

    private String surname;

    @ManyToMany
    @JoinTable(
            name = "table_ismi",
            joinColumns = {@JoinColumn(name = "ilk_column")},
            inverseJoinColumns = {@JoinColumn(name = "ikinci_column")}
    )
    private List<Lesson> lessonList = new ArrayList<>();

    public Student(){

    }
    public Student(int id, String name, String surname, List<Lesson> lessonList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.lessonList = lessonList;
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

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", lessonList=" + lessonList +
                '}';
    }
}
