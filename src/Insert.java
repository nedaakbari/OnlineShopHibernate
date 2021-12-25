import model.Address;
import model.Customer;
import model.enumeration.Category;
import model.enumeration.ElectronicTypes;
import model.enumeration.ReadingTypes;
import model.enumeration.ShoeType;
import model.product.ElectronicDevices;
import model.product.Readable;
import model.product.Shoe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {

    //static ProductDao productDao = new ProductDao();

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();


        Readable book = Readable.builder().withPrice(12.000).withDescription("its about somthing")
                .withPublisherName("sahel").withAuthorName("jack").withTitle("java")
                .withCategory(Category.READING).withReadingTypes(ReadingTypes.BOOK).withGenre("toturial").build();
        book.setAvailable(2);

        Readable magazine = Readable.builder().withTitle("robatic").withCategory(Category.READING).withDescription("all about")
                .withPrice(25000).withPage(124).withReadingTypes(ReadingTypes.MAGAZINE).build();
        magazine.setAvailable(4);

        ElectronicDevices tv = ElectronicDevices.builder().manufacturer("samsung").model("ssd").price(4000)
                .description("tv 24 inch").category(Category.ELECTRONIC).electronicTypes(ElectronicTypes.TELEVISION).build();
        tv.setAvailable(5);

        ElectronicDevices radio = ElectronicDevices.builder().manufacturer("lg").model("245").price(2500)
                .description("4 wolt").category(Category.ELECTRONIC).electronicTypes(ElectronicTypes.RADIO).build();
        radio.setAvailable(10);

        Shoe sport = Shoe.builder().price(14000).category(Category.SHOE).description("CASUAL for some dd").shoeType(ShoeType.SPORT)
                .size(24).model("nike").build();
        sport.setAvailable(6);

        Shoe formal = Shoe.builder().price(14000).category(Category.SHOE).description("CASUAL for some dd").shoeType(ShoeType.CASUAL)
                .size(24).model("gucci").build();
        formal.setAvailable(10);


        Address address = new Address();
        address.setStreet("engheleb");
        address.setCity("shiraz");
        address.setZipCode("123Bn");

        Customer customer = new Customer();
        customer.setFirstName("neda");
        customer.setLastName("akbari");
        customer.setAddress(address);
        customer.setPassword("111");
        customer.setUserName("111");
        customer.setPhoneNumber("0937");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        session.save(magazine);
        session.save(tv);
        session.save(radio);
        session.save(sport);
        session.save(formal);

        session.save(customer);
        transaction.commit();
        session.close();
      /*  productDao.save(book);
        productDao.save(magazine);
        productDao.save(tv);
        productDao.save(radio);
        productDao.save(sport);
        productDao.save(formal);*/

    }

}
