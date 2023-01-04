package s11FetchTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class).addAnnotatedClass(Department.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Department department = session.get(Department.class, 1021);
        System.out.println(department);

        tx.commit();
        session.close();
        sessionFactory.close();

        System.out.println(department.getTeacherList());




    }
}
