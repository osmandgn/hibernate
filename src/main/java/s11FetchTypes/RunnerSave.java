package s11FetchTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave {
    public static void main(String[] args) {

        Department department = new Department();
        department.setName("Math");

        Department department1 = new Department();
        department1.setName("Eng");

        Teacher teacher = new Teacher();
        teacher.setName("Osman");
        teacher.setDepartment(department);

        Teacher teacher1 = new Teacher();
        teacher1.setName("Hakan");
        teacher1.setDepartment(department1);

        Teacher teacher2 = new Teacher();
        teacher2.setName("Murat");
        teacher2.setDepartment(department);

        Teacher teacher3 = new Teacher();
        teacher3.setName("Yusuf");
        teacher3.setDepartment(department1);

        List<Teacher> teacherList1 = new ArrayList<>();
        teacherList1.add(teacher);
        teacherList1.add(teacher1);

        List<Teacher> teacherList2 = new ArrayList<>();
        teacherList1.add(teacher2);
        teacherList1.add(teacher3);

        department.setTeacherList(teacherList1);

        department1.setTeacherList(teacherList2);

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class).addAnnotatedClass(Department.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(department);
        session.save(department1);



        tx.commit();
        session.close();
        sessionFactory.close();








    }
}
