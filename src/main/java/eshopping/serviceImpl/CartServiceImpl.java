package eshopping.serviceImpl;

import eshopping.dao.CartDao;
import eshopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import eshopping.domain.Cart;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

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
