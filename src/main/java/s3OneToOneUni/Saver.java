package s3OneToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Saver {
    public static void main(String[] args) {



        Student sdt = new Student();
        sdt.setName("Osman");
        sdt.setSurname("Dogan");

        Address address = new Address();
        address.setZipCode("1234");
        address.setStreet("Kemal Pasa");
        sdt.setAddress(address);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Address.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(address);
        session.save(sdt);


        tx.commit();
        sf.close();
        session.close();

    }
}
