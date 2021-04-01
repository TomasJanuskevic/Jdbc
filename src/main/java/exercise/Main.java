package exercise;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateConnector.getSessionFactory().openSession();
        session.beginTransaction();
        Phone phone1 = new Phone();
        phone1.setBrand("Samsung");

        Phone phone2 = new Phone();
        phone2.setBrand("Huawei");

        Person person1 = new Person();
        person1.setName("Jonas");
        person1.setPhone(phone1);

        Person person2 = new Person();
        person2.setName("Petras");
        person2.setPhone(phone2);

        Car car1 = new Car();
        car1.setModel("Audi");
        car1.setPrice(12000);
        Car car2 = new Car();
        car2.setModel("Volvo");
        car2.setPrice(15000);

        person1.setCar(car1);
        person2.setCar(car2);

        session.save(person1);
        session.save(person2);
        session.getTransaction().commit();
    }
}
