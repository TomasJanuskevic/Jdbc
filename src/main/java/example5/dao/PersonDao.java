package example5.dao;

import example5.model.Person;
import example5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * DATA ACCESS OBJECT
 * reikalingas funkcijoms saveikauti su duomenu baze
 */
public class PersonDao {
    public void createPerson(Person person) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        System.out.println("Inserting new person in database");
        session.save(person);
        transaction.commit();
    }

    public Person getPerson(Long id) {
        Person person = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            person = session.find(Person.class, id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return person;
    }

    public void deletePerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Pradedam transavtion (unit of work)
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        //uzdarome/sucomittinam transaction
        transaction.commit();
    }

    public void updatePerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
    }

    public List<Person> getPersonByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createNamedQuery("get_person_by_name", Person.class);
        //Select * FROM person where name LIKE '%eda%'
        query = query.setParameter("name", "%" + name + "%");
        List<Person> persons = query.list();
        return persons;
    }


}
