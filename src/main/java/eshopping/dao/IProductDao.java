package eshopping.dao;

import eshopping.domain.Product;

import java.util.List;

public interface IProductDao extends CrudDao<Product, Integer>{
    List<Product> getRecentProducts();
}
