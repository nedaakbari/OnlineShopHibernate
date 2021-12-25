package dao;

import model.Card;
import model.CardItem;
import model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;

import java.util.List;

public class CardDao extends BaseDao{

    public void saveCard(Card card) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(card);
        transaction.commit();
        session.close();
    }

    public void deleteCardItem(CardItem cardItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cardItem);
        transaction.commit();
        session.close();
    }

    public void saveCardItem(CardItem cardItem) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cardItem);
        transaction.commit();
        session.close();
    }

    public List<Card> findCustomersCard(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Card> cards;
        Query query = session.createQuery("From Card c join fetch c.Where c.customer.id = :customerId");
        query.setParameter("customerId", customer.getId());
        cards = query.list();
        transaction.commit();
        session.close();
        return cards;
    }//??????????stackOverFlow

 /*   public List<CardDto> findCard(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Card.class, "ca");
        criteria.createAlias("ca.customer", "cu");
        criteria.createAlias("ca.cardItems", "i");
        criteria.createAlias("i.product", "p");

        SimpleExpression originCond = Restrictions.eq("cu.id", customer.getId());
        criteria.add(originCond);

        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("p.category").as("productCategory"))
                .add(Projections.property("i.costOfItems").as("totalCostOfEachProduct"))
                .add(Projections.property("ca.totalCost").as("totalCost"))
                .add(Projections.property("i.id").as("id"))
                .add(Projections.property("i.count").as("count")));


        criteria.setResultTransformer(Transformers.aliasToBean(CardDto.class));
        List<CardDto> list = criteria.list();
        transaction.commit();
        session.close();
        return list;
    }*/

}
