package s12CriteriaAPI;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FetchCitizen {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Citizen.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();



        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Citizen> criteriaQuery = criteriaBuilder.createQuery(Citizen.class);
        Root<Citizen> root = criteriaQuery.from(Citizen.class);


//        criteriaQuery.select(root);
//        Query<Citizen> query =  session.createQuery(criteriaQuery);
//        List<Citizen> citizenList = query.getResultList();
//        citizenList.forEach(System.out::println);

        // Yaşı 60'dan büyük olanları getir.

        criteriaQuery.select(root).where(criteriaBuilder.greaterThan(root.get("age"), 60));
        Query<Citizen> query2 = session.createQuery(criteriaQuery);
        List<Citizen> citizenList1 = query2.getResultList();
        citizenList1.forEach(System.out::println);

//        int dgr1 = 50;
//        int dgr2= 60;
//        String hql = "Update Citizen c SET c.age=:dgr1 WHERE c.age<:dgr2";
//        Query query = session.createQuery(hql);
//        query.setParameter("dgr1", dgr1);
//        query.setParameter("dgr2", dgr2);
//        int updatedData = query.executeUpdate();
//        System.out.println("Guncellenen Citizen Sayisi " + updatedData);

        String str = "Citizen 0";
        String hql1 = "From Citizen c where c.name=:str";
        Query query = session.createQuery(hql1);
        query.setParameter("str", str);
        List<Citizen> citizens = query.getResultList();
        citizens.forEach(System.out::println);


        tx.commit();
        session.close();
        sf.close();


    }
}
