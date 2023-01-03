package s5ManyToOneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Fetcher {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(University.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // Student'lerin tamamini Cagir

        String hql = "From Student";
        List<Student> list = session.createQuery(hql, Student.class).getResultList();
        for (Student sdt: list){
            System.out.println(sdt);
        }

        System.out.println("********************");

        String hhhql = "From University";
        List<University> list1 = session.createQuery(hhhql, University.class).getResultList();
        for (University un: list1){
            System.out.println(un);
        }


//
                // Bellir bir ID ye sahip olani cagir

//        Student student = session.get(Student.class, 152);
//        System.out.println(student);

        // University ID'si 2 olani cagir

//        String hgl1 = "From Student s where s.university = 2";
//        List<Student> sdt = session.createQuery(hgl1, Student.class).getResultList();
//        for(Student s : sdt){
//            System.out.println(s);
//        }
//
//        sdt.forEach(s-> System.out.println(s)); // lambda


        tx.commit();
        sf.close();
        session.close();


    }
}
