package s16Practices;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FetchDoctor {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Doctor.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Doctor> docList = session.createQuery("From Doctor", Doctor.class).getResultList();
        docList.stream().forEach(System.out::println);


        session.getTransaction().commit();
        sessionFactory.close();






    }
}
