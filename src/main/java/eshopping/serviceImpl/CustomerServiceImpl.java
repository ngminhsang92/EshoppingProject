package eshopping.serviceImpl;

import java.util.List;

import eshopping.dao.UserDao;
import eshopping.integration.JMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshopping.dao.CustomerDao;
import eshopping.domain.Customer;
import eshopping.domain.Users;
import eshopping.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private JMSSender jmsSender;
    
    public void addCustomer(Customer customer){
        customerDao.addCustomer(customer);
        
        if (jmsSender != null)
        {
	        String message = String.format("%s#Dear %s your registration has been successfully submitted."
	        		, customer.getCustomerEmail()
	        		, customer.getCustomerName());
	        jmsSender.sendJMSMessage(message);
        }
    }
    public Customer getCustomerById(int customerId){
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username){
        return customerDao.getCustomerByUsername(username);
    }

	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

	public void enableDisableCustomer(int customerId){
		Customer customer = customerDao.getCustomerById(customerId);
        customer.setEnabled(!customer.isEnabled());
        customerDao.updateCustomer(customer);
        
        Users user = userDao.getUserByUsername(customer.getUsername());
        if (user !=null) {
            user.setEnabled(customer.isEnabled());
            userDao.update(user);
        }
	}

    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }
}