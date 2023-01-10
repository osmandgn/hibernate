package s15EntityLifeCycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saver {

    public static void main(String[] args) {

        Student student1 = new Student();  // !!! Transient State
        student1.setName("Recep Bey");
        student1.setMathGrade(99);

        Student student2 = new Student(); // !!! Transient State
        student2.setName("Emir Bey");
        student2.setMathGrade(99);

        Student student3 = new Student(); // !!! Transient State
        student3.setName("Tarık Bey");
        student3.setMathGrade(99);


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(student1); ///!!! Persisted State

        student1.setName("Güncellenmiş Recep Bey");

        session.evict(student1); // !!! to Detached state

        session.update(student1); // detached olmuş to persisted State
        session.merge(student1);// detached to persisted State

        tx.commit();
        session.close();
        sf.close();
    }
}
