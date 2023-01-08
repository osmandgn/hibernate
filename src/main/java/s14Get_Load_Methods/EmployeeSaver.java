package s14Get_Load_Methods;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeSaver {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setName("Osman");
        Employee employee1 = new Employee();
        employee1.setName("Hakan");

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(employee1);
        session.save(employee);


        tx.commit();
        session.close();
        sf.close();





    }
}
