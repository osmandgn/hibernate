package s3OneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fetcher {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                        addAnnotatedClass(Student.class).addAnnotatedClass(Address.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student std = session.get(Student.class, 1);
        System.out.println(std);


        tx.commit();
        sf.close();
        session.close();

    }
}
