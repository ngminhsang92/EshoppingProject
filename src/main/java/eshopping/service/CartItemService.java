package eshopping.service;


import eshopping.domain.Cart;
import eshopping.domain.CartItem;
import eshopping.domain.CustomerOrder;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);
    
    void removeAllCartItems(CustomerOrder order);

    CartItem getCartItemByProductId(int productId);

}
