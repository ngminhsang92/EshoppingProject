package eshopping.service;

import eshopping.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProductList();

    Product getProductById (Integer id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getRecentProducts();

    List<Product> getProductByCategoryId(Integer categoryId);

    void deleteAllProduct();
}
