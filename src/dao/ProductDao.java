package dao;

import model.enumeration.Category;
import model.product.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDao extends BaseDao {
    SessionFactory sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();

    public void save(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        session.update(product);
        transaction.commit();
        session.close();//???????????اینجا پروداکتی نمیشناسه که بخواد ابدیت بزنه
    }

    public Product findById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Product p where p.id=:id");
        query.setParameter("id", id);
        Product product = (Product) query.uniqueResult();
        transaction.commit();
        session.close();
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> products;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Product");
        products = query.list();
        transaction.commit();
        session.close();
        return products;
    }

    public List<Product> getAllThisType(Category category) {
        List<Product> products;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Product p where p.category=:category");
        query.setParameter("category", category);
        products = query.list();
        transaction.commit();
        session.close();
        return products;
    }
    //اگه بخوام از کرایتریا پیدا کنم که مثلا خواندنی ها رو هم فیلتر کنه باید چیکار کنم
}
