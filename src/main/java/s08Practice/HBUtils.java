package s08Practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HBUtils {
    public static SessionFactory sessionFactory;
    public static Session session;
    public static Transaction tx;

    static {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Citizen.class).addAnnotatedClass(Passport.class);
        sessionFactory = cfg.buildSessionFactory();
    }

    static {
       session = sessionFactory.openSession();
    }

    static {
        tx = session.beginTransaction();
    }

    public static void saveObject(Object o){
        session.save(o);
    }

    public static Object getObject(Class className, int Id){
        return session.get(className, Id);
    }

    public static void beginTransaction(){
        session.beginTransaction();
    }
    public static void commitAndClose(){
        tx.commit();
        session.close();
        sessionFactory.close();
    }

}
