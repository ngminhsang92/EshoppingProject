package eshopping.dao.daoImpl;

import eshopping.dao.UserDao;
import eshopping.domain.Users;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void update(Users user){
    	Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    public Users getUserByUsername(String username){
    	Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users where username = ?");
        query.setString(0, username);

        return (Users) query.uniqueResult();
    }


}