package onetomany;

import onetoone.HibernateDatabaseConnector;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class OneToManyMain {
    public static void main(String[] args) {
        Session session = HibernateDatabaseConnector.getSessionFactory().openSession();
        session.beginTransaction();

        Cart krepselis = new Cart();

        Item bananas = new Item();
        bananas.setName("bananas");
        bananas.setCart(krepselis);

        Item obuolys = new Item();
        obuolys.setName("obuolys");
        obuolys.setCart(krepselis);

        session.save(krepselis);
        session.save(bananas);
        session.save(obuolys);

        Cart kitasKrepselis = new Cart();
        Item pc = new Item();
        pc.setName("HP PC");
        pc.setCart(kitasKrepselis);
        Item mouse = new Item();
        mouse.setName("Apple mouse");
        mouse.setCart(kitasKrepselis);
        Item monitor = new Item();
        monitor.setName("Samsung");
        monitor.setCart(kitasKrepselis);

        session.save(kitasKrepselis);
        session.save(pc);
        session.save(mouse);
        session.save(monitor);

        session.getTransaction().commit();

    }
}
