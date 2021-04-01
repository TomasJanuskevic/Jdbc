package example5.dao;

import example5.model.Car2;
import example5.util.CarUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarDao {
    public void createCar(Car2 car) {
        Session session = CarUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Create car");
        session.save(car);
        transaction.commit();
    }
}
