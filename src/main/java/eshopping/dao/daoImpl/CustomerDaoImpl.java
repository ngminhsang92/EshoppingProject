package eshopping.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshopping.dao.CustomerDao;
import eshopping.domain.Authorities;
import eshopping.domain.Cart;
import eshopping.domain.Customer;
import eshopping.domain.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    public void addCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();

        //hash password
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getUsername());
        newAuthorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(int customerId){
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;

    }

    public Customer getCustomerByUsername(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);

        return (Customer) query.uniqueResult();
    }

	public void updateCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
        session.flush();
	}

    public void deleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer.getBillingAddress());
        session.delete(customer.getShippingAddress());
        session.delete(customer.getCart());
        Query query = session.createQuery("delete from Customer");
        query.executeUpdate();
        session.flush();
    }
}