package eshopping.dao;

import java.util.List;

import eshopping.domain.Customer;

public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
    
    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);
}

