package eshopping.serviceImpl;

import eshopping.dao.CustomerOrderDao;
import eshopping.domain.Cart;
import eshopping.domain.CartItem;
import eshopping.domain.CustomerOrder;
import eshopping.service.CartService;
import eshopping.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId){
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }

    public CustomerOrder loadById(int id) {
        return customerOrderDao.loadById(id);
    }

    public List<CustomerOrder> getAllOrders() {
        return customerOrderDao.getAllOrders();
    }

} // The End of Class;
