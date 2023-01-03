package s1SaveAndFetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SdtRunner {
    public static void main(String[] args) {

        Student sdt1 = new Student();
        sdt1.setName("Osman");
        sdt1.setSurname("Dogan");
        sdt1.setAddress("Istanbul");

        Student sdt2 = new Student();
        sdt2.setName("Hakan");
        sdt2.setSurname("Kara");
        sdt2.setAddress("Ankara");

        Student sdt3 = new Student();
        sdt3.setName("Murat");
        sdt3.setSurname("Bag");
        sdt3.setAddress("Karadag");





        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(sdt1);
        session.save(sdt2);
        session.save(sdt3);



        tx.commit();
        sf.close();
        session.close();




    }

}
