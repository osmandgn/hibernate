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

        Doctor theDoctor = session.get(Doctor.class, 44);
        theDoctor.setName("Hemsin");


        session.getTransaction().commit();


        System.out.println("*****************************");

        List<Doctor> docList = session.createQuery("From Doctor", Doctor.class).getResultList();
        docList.stream().forEach(System.out::println);

        session.close();
        sessionFactory.close();








    }
}
