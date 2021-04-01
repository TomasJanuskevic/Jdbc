package shop.dao;

import org.hibernate.Session;
import shop.DatabaseUtils;
import shop.User;

import javax.persistence.Query;

public class UserDao {
    public User getUser(Long id) {
        User user = null;
        try {
            Session session = DatabaseUtils.getSessionFactory().openSession();
            user = session.find(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUser(String name) {
        User user = null;
        try {
            Session session = DatabaseUtils.getSessionFactory().openSession();
            Query query = session.createQuery("from User where name=:name", User.class);
            query.setParameter("name", name);
            user = (User) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;


    }
}
