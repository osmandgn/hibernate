package s6OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Saver {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Osman");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Hakan");

        Book book1 = new Book();
        book1.setId(101);
        book1.setName("Art Book");

        Book book2 = new Book();
        book2.setId(102);
        book2.setName("Math Book");

        Book book3 = new Book();
        book3.setId(103);
        book3.setName("Java Book");

        student1.getBookList().add(book1);
        student1.getBookList().add(book3);
        student2.getBookList().add(book2);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);

        session.save(student1);
        session.save(student2);

        tx.commit();
        sf.close();
        session.close();

    }
}
