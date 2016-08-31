package eshopping.service;

import eshopping.domain.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
    
    Long getTotalNoOfCart();
}
