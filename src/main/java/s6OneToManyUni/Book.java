package s6OneToManyUni;

import javax.persistence.*;

@Entity
@Table(name = "t_denemebook")
public class Book {

    @Column(name = "book_id")
    @Id
    private int id;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
