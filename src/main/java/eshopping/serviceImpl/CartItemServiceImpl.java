package eshopping.serviceImpl;

import eshopping.dao.CartItemDao;
import eshopping.domain.Cart;
import eshopping.domain.CartItem;
import eshopping.domain.CustomerOrder;
import eshopping.integration.JMSSender;
import eshopping.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    @Autowired
    private JMSSender jmsSender;
    
    public void addCartItem(CartItem cartItem){
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(CustomerOrder order){
        cartItemDao.removeAllCartItems(order.getCart());
        if (jmsSender != null)
        {
	        String message = String.format("%s#Dear %s, Please be confirmed that your order with total %s has been successfully submitted."
	        		, order.getCart().getCustomer().getCustomerEmail()
	        		, order.getCart().getCustomer().getCustomerName()
	        		, getCustomerOrderGrandTotal(order.getCart()));
	        jmsSender.sendJMSMessage(message);
        }        
    }
    
    public double getCustomerOrderGrandTotal(Cart cart){
        double grandTotal = 0;
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }

    public CartItem getCartItemByProductId(int productId){
        return cartItemDao.getCartItemByProductId(productId);
    }

	public void removeAllCartItems(Cart cart) {
		 cartItemDao.removeAllCartItems(cart);
	}


} // The End of Class;
