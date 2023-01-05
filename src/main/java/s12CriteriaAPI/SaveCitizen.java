package s12CriteriaAPI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class SaveCitizen {
    public static void main(String[] args) {
        Random random = new Random();


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Citizen.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        for (int i = 0; i < 20; i++) {
            Citizen citizen = new Citizen();
            citizen.setName("Citizen " + i);
            citizen.setAge(random.nextInt(100));
            session.save(citizen);
        }

        
        tx.commit();
        session.close();
        sf.close();



    }
}
