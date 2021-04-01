package example5;

import example5.dao.PersonDao;
import example5.model.Person;
import example5.util.HibernateUtil;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
      //  HibernateUtil.getSessionFactory();
        PersonDao personDao = new PersonDao();
        //Create person
        Person person = new Person(null, "Henry", "Haynes", "henry@gmail.com", "USA");
        personDao.createPerson(person);

        //find person
        System.out.println(personDao.getPerson(1L));

        //delete person
       // personDao.deletePerson(person);

        //find person
        System.out.println(personDao.getPerson(1L));


        //again create person
       // personDao.createPerson(person);
        //find person
        System.out.println(personDao.getPerson(1L));


        person.setCountry("Russia");
        person.setLastName("Potter");
        personDao.updatePerson(person);
        //find person
        System.out.println(personDao.getPerson(1L));

        Person person2 = new Person(null, "Benry", "Zaynes", "Benry@gmail.com", "Poland");
        personDao.createPerson(person2);
        Person person3 = new Person(null, "Zenry", "Taynes", "Zenry@gmail.com", "Lithuania");
        personDao.createPerson(person3);
        List<Person> persons = personDao.getPersonByName("enr");
        for (Person p : persons) {
            System.out.println(p);
        }

        personDao.deletePerson(person3);

    }
}
