package s13Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.print.Doc;

public class FetchDoctor {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Doctor doc = session.get(Doctor.class, 1);
        System.out.println(doc);
        System.out.println("*".repeat(5) + " Query Sonu " + "*".repeat(5));

        tx.commit();
        session.close();

        System.out.println("*".repeat(5) + " Session Kapandi " + "*".repeat(5));

        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();

        Doctor doc1 = session2.get(Doctor.class, 1);
        System.out.println(doc1);

        tx2.commit();
        session2.close();
        sf.close();


    }
}


