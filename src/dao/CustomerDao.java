package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDao extends BaseDao {

    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    public Customer findCustomer(String userName,String passWord) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Customer c Where c.userName = :userName And c.password= :password");
        query.setParameter("userName",userName);
        query.setParameter("password", passWord);
        Customer customer = (Customer) query.uniqueResult();
        transaction.commit();
        session.close();
        return customer;
    }

    public List<Customer> findAllCustomers() {
        List<Customer> customers;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("From Customer");
        customers = query.list();
        transaction.commit();
        session.close();
        return customers;
    }

    public static void main(String[] args) {
       /* Customer customer= new Customer();
        customer.setPassword("333");
        customer.setUserName("333");
        CustomerDao customerDao=new CustomerDao();
        customerDao.saveCustomer(customer);*/
        SessionFactory sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer);
        transaction.commit();
        session.close();

    }

}
