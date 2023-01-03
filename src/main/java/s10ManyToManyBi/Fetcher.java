package s10ManyToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Fetcher {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).addAnnotatedClass(Lesson.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();


        Student sdt = session.get(Student.class, 1);
        System.out.println(sdt.getLessonList());

        List<Lesson> lessonList = session.createQuery("From Lesson").getResultList();
        lessonList.forEach(System.out::println);



        transaction.commit();
        sf.close();
        session.close();




    }
}
