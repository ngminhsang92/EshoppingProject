package eshopping.dao;

import java.util.List;

import eshopping.domain.CustomerOrder;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);
    
    public List<CustomerOrder> getAllOrders();
    
    public CustomerOrder loadById(int id);
}
