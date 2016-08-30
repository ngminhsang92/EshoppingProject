package eshopping.service;

import java.util.List;

import eshopping.domain.CustomerOrder;



public interface CustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
    
    public List<CustomerOrder> getAllOrders();
    
    public CustomerOrder loadById(int id);
    
}
