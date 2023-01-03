package s10ManyToManyBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Saver {
    public static void main(String[] args) {

        Lesson lesson = new Lesson(1, "Math");
        Lesson lesson1 = new Lesson(2, "Eng");
        Lesson lesson2 = new Lesson(3, "Computer");
        Lesson lesson3 = new Lesson(4, "Phs");

        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(lesson);
        lessonList.add(lesson2);

        List<Lesson> lessonList1 = new ArrayList<>();
        lessonList1.add(lesson);
        lessonList1.add(lesson3);

        List<Lesson> lessonList2 = new ArrayList<>();
        lessonList2.add(lesson1);
        lessonList2.add(lesson2);

        Student student1 = new Student(1, "Osman", "Dogan", lessonList);
        Student student2 = new Student(2, "Hakan", "Tasiyan", lessonList1);
        Student student3 = new Student(3, "Ismail", "Tas", lessonList2);


        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).addAnnotatedClass(Lesson.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(lesson);
        session.save(lesson1);
        session.save(lesson2);
        session.save(lesson3);


        transaction.commit();
        sf.close();
        session.close();









    }

}
