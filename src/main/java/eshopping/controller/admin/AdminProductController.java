package eshopping.controller.admin;

import eshopping.domain.Category;
import eshopping.domain.Product;
import eshopping.service.ICategoryService;
import eshopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminProductController {

	private Path path;

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping("/product/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		//product.setProductCategory("instrument");
		product.setProductCondition("new");
		product.setProductStatus("active");
		model.addAttribute("product", product);
		populateDefaultModel(model);
		return "adminaddProduct";
	}
	private void populateDefaultModel(Model model) {
		List<Category> categories = categoryService.getCategoryList();
		Map<Integer, String> categoryList = new LinkedHashMap<Integer, String>();
		for(Category cat : categories){
			categoryList.put(cat.getCategoryId(), cat.getCategoryName());
		}

		model.addAttribute("categoryList", categoryList);
	}
	@RequestMapping("/productList/all")
	public String getProducts(Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("products", products);

		return "adminproductList";
	}

	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                 HttpServletRequest request) {
		if (result.hasErrors()) {
			return "adminaddProduct";
		}

		MultipartFile productImage = product.getProductImage();

		if (productImage != null && !productImage.isEmpty()) {
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");

			try {
				product.setImagebytes(new javax.sql.rowset.serial.SerialBlob(productImage.getBytes()));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			productService.addProduct(product);
			path = Paths.get(rootDirectory + "/WEB-INF/resources/images/product_" + product.getProductId() + ".png");

			try {
				File img = new File(path.toString());
				productImage.transferTo(img);
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		return "redirect:/admin/productList/all";
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id,  Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        populateDefaultModel(model);
        return "admineditProduct";
    }

	@RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result,
                                  HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editProduct";
		}

		MultipartFile productImage = product.getProductImage();

		if (productImage != null && !productImage.isEmpty()) {
			String rootDirectory = request.getSession().getServletContext().getRealPath("/");

			try {
				product.setImagebytes(new javax.sql.rowset.serial.SerialBlob(productImage.getBytes()));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			path = Paths.get(rootDirectory + "/WEB-INF/resources/images/product_" + product.getProductId() + ".png");

			try {
				File img = new File(path.toString());
				productImage.transferTo(img);
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		productService.editProduct(product);

		return "redirect:/admin/productList/all";
    }

	@RequestMapping("/product/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "/WEB-INF/resources/images/product_" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		Product product = productService.getProductById(id);
		productService.deleteProduct(product);

		return "redirect:/admin/productList/all";
	}

} // The End of Class;
