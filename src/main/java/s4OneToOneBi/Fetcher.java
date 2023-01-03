package s4OneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class Fetcher {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Citizen.class).addAnnotatedClass(Passport.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        String hql = "FROM Citizen";
//        List<Citizen> cList = session.createQuery(hql, Citizen.class).getResultList();
//        for(Citizen citizen: cList){
//            System.out.println(citizen);
//        }

//        Citizen citizen = session.get(Citizen.class, 19);
//        System.out.println(citizen.getPassport()); // citizen'den pasaportuna ulastik.
//
//        Passport passport = session.get(Passport.class, 18);
//        System.out.println(passport.getCitizen()); // passport'tan sahibine ulastik.


        String hql1 = "Select c.name, p.city From Citizen c INNER JOIN FETCH Passport p ON p.id = c.passport";

        List<Object[]> list = session.createQuery(hql1).getResultList();
        for (Object[] obj: list){
            System.out.println(Arrays.toString(obj));
        }






        tx.commit();
        sf.close();
        session.close();


    }
}
