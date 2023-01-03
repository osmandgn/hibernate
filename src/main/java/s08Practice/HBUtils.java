package s08Practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBUtils {
    public static Session session;

    public static SessionFactory sessionFactory(Class class1, Class class2){
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(class1).addAnnotatedClass(class2);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }

    static {
       session = sessionFactory(Citizen.class, Passport.class).openSession();
    }

}
