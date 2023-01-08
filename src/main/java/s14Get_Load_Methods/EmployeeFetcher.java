package s14Get_Load_Methods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.List;

public class EmployeeFetcher {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        List<Employee> employeeList = session.createQuery("From Employee").getResultList();
        employeeList.forEach(System.out::println);

//        Employee emp = session.load(Employee.class, 1L);
//        System.out.println("Load Metodu Bitti");
//        session.delete(emp); // obje silindi.
//





        tx.commit();
        session.close();
        sf.close();



    }

}
