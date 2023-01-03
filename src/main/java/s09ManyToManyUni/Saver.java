package s09ManyToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Saver {
    public static void main(String[] args) {

        Lesson lesson = new Lesson(1, "Math");
        Lesson lesson1 = new Lesson(2, "Eng");
        Lesson lesson2 = new Lesson(3, "Biology");

        Student student = new Student(1, "Osman");
        student.getLessonList().add(lesson1);
        student.getLessonList().add(lesson2);
        student.getLessonList().add(lesson);



        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Lesson.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();



        session.save(student);
        session.save(lesson);
        session.save(lesson1);
        session.save(lesson2);




        transaction.commit();
        session.close();
        sf.close();


    }
}
