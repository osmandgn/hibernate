package s4OneToOneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saver {
    public static void main(String[] args) {

        Citizen citizen = new Citizen();
        citizen.setName("Osman");
        citizen.setSurname("Dogan");

        Citizen citizen1 = new Citizen();
        citizen1.setName("Hakan");
        citizen1.setSurname("Kara");

        Passport passport = new Passport();
        passport.setCity("Urfa");
        passport.setGender("Male");

        Passport passport1 = new Passport();
        passport1.setGender("Male");
        passport1.setCity("Izmir");

        citizen.setPassport(passport);
        passport.setCitizen(citizen);

        citizen1.setPassport(passport1);
        passport1.setCitizen(citizen1);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Citizen.class).addAnnotatedClass(Passport.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(passport1);
        session.save(citizen1);


        tx.commit();
        sf.close();
        session.close();





    }
}
