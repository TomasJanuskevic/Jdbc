package shop;

import org.hibernate.Session;
import org.hibernate.Transaction;
import shop.dao.ProductDao;
import shop.dao.UserDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class Main {


    public static void main(String[] args) throws SQLException {
/*        ProductDao productDao = new ProductDao();
        productDao.printAllProducts();*/

/*        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Product apple = session.find(Product.class, 1L);
        Product orange = session.find(Product.class, 2L);
        User petras = new User("Petras", "test");
        Cart cart1 = new Cart(petras);
        BuyItem buyItem1 = new BuyItem(5, apple, cart1);
        BuyItem buyItem2 = new BuyItem(10,orange,cart1);

        session.save(petras);
        session.save(cart1);
        session.save(buyItem1);
        session.save(buyItem2);


        UserDao userDao = new UserDao();
        User petras2 = userDao.getUser("Petras");
        Cart cart = new Cart(petras2);
        ProductDao productDao = new ProductDao();
        Product apple2 = productDao.getProduct(1L);
        Product banana = productDao.getProduct(4L);
        BuyItem buyItem3 = new BuyItem(3, apple2, cart);
        BuyItem buyItem4 = new BuyItem(6, banana, cart);

        cart.addBuyItem(buyItem3);
        cart.addBuyItem(buyItem4);
        petras.addCart(cart);


        session.update(petras);
        session.save(cart);
        session.save(buyItem1);
        session.save(buyItem2);




        transaction.commit();
        DatabaseUtils.shutDown();*/

        Application application = new Application();
        application.application();


    }
}

