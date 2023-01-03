package s10ManyToManyBi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lesson {

    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "lessonList")
    private List<Student> studentList = new ArrayList<>();

    public Lesson(){

    }
    public Lesson(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
