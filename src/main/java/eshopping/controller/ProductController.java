package eshopping.controller;

import eshopping.domain.Product;
import eshopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping("/productList/all")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }

    @RequestMapping("/search")
    public String getProductBySearch(@RequestParam(name="category", required=false ) String category,
                                     @RequestParam(name="keyword", required=false ) String keyword, Model model){

        List<Product> products = null;
        if (category.toLowerCase().equals("all")) {
            products = productService.getProductList();
        }else{
            products = productService.getProductByCategoryId(Integer.valueOf(category));
        }
        model.addAttribute("products", products);
        model.addAttribute("searchCondition", keyword);

        return "productList";
    }

    @RequestMapping("/productList")
    public String getProductByCategory(@RequestParam(name="category", required=false ) String categoryId, Model model){
        List<Product> products = productService.getProductByCategoryId(Integer.valueOf(categoryId));
        model.addAttribute("products", products);
        return "productList";
    }

}
