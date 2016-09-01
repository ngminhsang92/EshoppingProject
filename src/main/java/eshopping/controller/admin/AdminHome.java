package eshopping.controller.admin;

import eshopping.domain.Customer;
import eshopping.domain.CustomerOrder;
import eshopping.domain.Product;
import eshopping.service.CartService;
import eshopping.service.CustomerOrderService;
import eshopping.service.CustomerService;
import eshopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private IProductService productService;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private CustomerOrderService customerOrderService;
    
    @Autowired
    private CartService cartService;

    @RequestMapping
    public String adminPage(Model model){
    	 List<Product> products = productService.getProductList();
         model.addAttribute("noofproducts", products.size());
         
         Long totalcustomers = cartService.getTotalNoOfCart();
         model.addAttribute("totalcustomers", totalcustomers);
         
         List<CustomerOrder> top5order = customerOrderService.getAllOrders();
         model.addAttribute("top5order", top5order);
         
         return "adminnewhome";
    }
    @RequestMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @RequestMapping("/customer")
    public String customerManagerment(Model model){

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "admincustomerManagement";
    }
    
    @RequestMapping("/customer/enableDisable/{id}")
    public String enableDisable(@PathVariable("id") int id,  Model model){ 
        customerService.enableDisableCustomer(id);
        return "redirect:/admin/customer";
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteUser(@PathVariable("id") int id,  Model model){
        Customer customer = customerService.getCustomerById(id);
        customerService.deleteCustomer(customer);
        return "redirect:/admin/customer";
    }



} // The End of Class;
