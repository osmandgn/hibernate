package s6OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Fetcher {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "From Student";
        List<Student> studentList = session.createQuery(hql, Student.class).getResultList();
        studentList.forEach(System.out::println);

        String hhql = "From Book";
        List<Book> bookList = session.createQuery(hhql, Book.class).getResultList();
        bookList.forEach(System.out::println);

        tx.commit();
        sf.close();
        session.close();


    }
}
