package s7OneToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saver {
    public static void main(String[] args) {

        Student student = new Student();
        student.setId(1);
        student.setName("Osman");

        Student student1 = new Student();
        student1.setId(2);
        student1.setName("Hakan");

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book book5 = new Book();

        book1.setId(101);
        book1.setName("Math Book");

        book2.setId(102);
        book2.setName("Art Book");

        book3.setId(103);
        book3.setName("Java Book");

        book4.setId(104);
        book4.setName("A Book");

        book5.setId(105);
        book5.setName("B Book");

        student.getBookList().add(book1);
        student.getBookList().add(book2);
        student.getBookList().add(book3);
        student1.getBookList().add(book4);
        student1.getBookList().add(book5);

        book1.setStudent(student);
        book2.setStudent(student);
        book3.setStudent(student);

        book4.setStudent(student1);
        book5.setStudent(student1);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);

        tx.commit();
        sf.close();
        session.close();
    }
}
