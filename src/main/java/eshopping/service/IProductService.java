package eshopping.service;

import eshopping.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProductList();

    Product getProductById (int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getRecentProducts();
}
