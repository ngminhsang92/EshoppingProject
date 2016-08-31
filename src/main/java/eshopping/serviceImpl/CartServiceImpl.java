package eshopping.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.estore.dao.CartDao;

import eshopping.domain.Cart;

public class CartServiceImpl {
	

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId){
        return cartDao.getCartById(cartId);
    }

    public void update(Cart cart){
        cartDao.update(cart);
    }

	public Long getTotalNoOfCart() {
		// TODO Auto-generated method stub
		return cartDao.getTotalNoOfCart();
	}
	
}
