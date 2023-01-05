package s13Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import s12CriteriaAPI.Citizen;

public class SaveDoctor {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        for (int i = 0; i < 3; i++) {
            Doctor doctor = new Doctor(i,"DoctorName " + i, "DoctorName " + i);
            session.save(doctor);
        }


        tx.commit();
        session.close();
        sf.close();
    }
}
