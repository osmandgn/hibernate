package s16Practices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import s2Embeddable.Student;

public class SaveDoctor {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Mustafa", "Bogaz");
        Doctor doctor1 = new Doctor("Erhan", "Bogaz");
        Doctor doctor2 = new Doctor("Harun", "Bogaz");

//        Configuration con = new Configuration().configure().addAnnotatedClass(Doctor.class);
//        SessionFactory sessionFactory = con.buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Doctor.class).buildSessionFactory();
        Session session = factory.openSession();

        session.beginTransaction();

        session.save(doctor);
        session.save(doctor1);
        session.save(doctor2);
        session.getTransaction().commit();

        factory.close();
    }
}
