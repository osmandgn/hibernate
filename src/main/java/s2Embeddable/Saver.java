package s2Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saver {
    public static void main(String[] args) {

        Student sdt1 = new Student();
        sdt1.setName("Mehmet");
        sdt1.setSurname("Cem");

        Address address = new Address();
        address.setStreet("Karaca Cad.");
        address.setZipCode("63200");
        address.setCity("Ankara");

        sdt1.setAddress(address);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(sdt1);



        tx.commit();
        sf.close();
        session.close();






    }
}
