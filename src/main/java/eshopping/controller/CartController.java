package eshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import eshopping.domain.Cart;
import eshopping.domain.CartItem;
import eshopping.domain.Customer;
import eshopping.service.CartService;
import eshopping.service.CustomerService;

//test
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CartService cartService;

    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }
    

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
        model.addAttribute("cartId", cartId);
        Cart cart = cartService.getCartById(cartId);
        int counter = 0;
        if(cart != null){
        	List<CartItem> items = cart.getCartItems();
        	if(items != null){
        		counter = items.size();
        	}
        }
        model.addAttribute("counter", counter);
        return "cart";
    }

} // The End of Class;
