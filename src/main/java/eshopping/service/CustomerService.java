package eshopping.service;

import java.util.List;

import eshopping.domain.Customer;



public interface CustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
    
    void updateCustomer(Customer customer);

    void enableDisableCustomer(int customerId);

    void deleteCustomer(Customer customer);
}
