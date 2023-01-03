package s5ManyToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saver {
    public static void main(String[] args) {

        Student student1 = new Student();
        student1.setName("Osman");
        student1.setSurname("Dogan");

        Student student2 = new Student();
        student2.setName("Hakan");
        student2.setSurname("Tasiyan");

        University university = new University();
        university.setName("Marmara Universitesi");

        student1.setUniversity(university);
        student2.setUniversity(university);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(University.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(university);
        session.save(student1);
        session.save(student2);


        tx.commit();
        sf.close();
        session.close();








    }
}
