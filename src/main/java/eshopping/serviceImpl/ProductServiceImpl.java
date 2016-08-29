package eshopping.serviceImpl;

import eshopping.dao.IProductDao;
import eshopping.domain.Product;
import eshopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> getProductList() {
        return productDao.getList();
    }

    public Product getProductById(Integer id) {
        return productDao.getOneById(id);
    }

    public void addProduct(Product product) {
        productDao.add(product);
    }

    public void editProduct(Product product) {
        productDao.edit(product);
    }

    public void deleteProduct(Product product) {
        productDao.delete(product);
    }

    public List<Product> getRecentProducts() {
        return productDao.getRecentProducts();
    }

    public List<Product> getProductByCategoryId(Integer categoryId) {
        return productDao.getProductByCategoryId(categoryId);
    }
}
