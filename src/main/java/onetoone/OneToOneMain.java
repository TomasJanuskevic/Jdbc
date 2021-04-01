package onetoone;

import org.hibernate.Session;

public class OneToOneMain {
    public static void main(String[] args) {
        Session session = HibernateDatabaseConnector.getSessionFactory().openSession();
        session.beginTransaction();

        Book book = new Book();
        book.setTitle("Lord of the rings");

        session.save(book); //pirma saugom knyga AJIGU NETURIME CASCADE TYPE ALL

        Owner owner = new Owner();
        owner.setCountry("Latvia");
        owner.setName("Jefferson");
        owner.setBook(book); //uzsetinam knyga owneriui

        session.save(owner);
        session.getTransaction().commit();
        //Owner ownerFromDb = session.find(Owner.class, 1L);

    }
}
