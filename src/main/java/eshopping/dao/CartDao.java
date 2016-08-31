package eshopping.dao;


import java.io.IOException;

import eshopping.domain.Cart;

public interface CartDao {

    Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

    Long getTotalNoOfCart();
}

