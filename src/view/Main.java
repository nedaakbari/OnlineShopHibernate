package view;

import model.Customer;
import service.CardService;
import service.CustomerService;
import service.ProductService;

public class Main {
    static CustomerService customerService = new CustomerService();
    static ProductService productService = new ProductService();
    static CardService cardService = new CardService();

    public static void main(String[] args) {
        Customer customer = customerService.findCustomer("111", "111");
        /*
        System.out.println(customer);
        customer.setBalance(2000000);
        customerService.update(customer);
        List<Product> allThisType = productService.getAllThisType(Category.SHOE);
        allThisType.forEach(System.out::println);*/



       /* Product sport = productService.find(5);
        Product formal = productService.find(5);
        Set<CardItem> set = new HashSet<>();

        Card card = new Card();

        int count = 3;
        CardItem cardItem = null;
        if (sport.getAvailable() > count) {
            cardItem = new CardItem();
            cardItem.setProduct(sport);
            cardItem.setCount(count);
            cardItem.setCostOfItems(sport.getPrice()*count);
        }

        int counts = 2;
        CardItem cardItems = null;
        if (sport.getAvailable() > counts) {
            cardItems = new CardItem();
            cardItems.setProduct(formal);
            cardItems.setCount(counts);
            cardItems.setCostOfItems(formal.getPrice()*count);
        }


        set.add(cardItem);
        set.add(cardItems);

        card.setCardItems(set);
        card.setCustomer(customer);
        card.setTotalCost(sport.getPrice() * count+formal.getPrice() * count);
        cardService.save(card);
        cardItem.setCard(card);
        cardItems.setCard(card);
        cardService.saveCardItem(cardItem);
        cardService.saveCardItem(cardItems);
        customerService.update(customer);*/


        /*product.setAvailable(product.getAvailable() - count);
        productService.update(product)*/;//?????????????????????????




       /* List<Card> customersCard = cardService.findCustomersCard(customer);
        customersCard.forEach(System.out::println);*/

        // CardDao cardDao = new CardDao();
        /*List<CardDto> card = cardDao.findCard(customer);
        System.out.println("**********************");
        card.forEach(System.out::println);*/


    }
}
