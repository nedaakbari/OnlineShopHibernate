package service;

import dao.CardDao;
import model.Card;
import model.CardItem;

public class CardService {
    CardDao cardDao = new CardDao();

    public void save(Card card) {
        cardDao.saveCard(card);
    }

    public void saveCardItem(CardItem cardItem) {
        cardDao.saveCardItem(cardItem);
    }

    /*public List<Card> findCustomersCard(Customer customer){
        return  cardDao.findCustomersCard(customer);
    }*/
}
