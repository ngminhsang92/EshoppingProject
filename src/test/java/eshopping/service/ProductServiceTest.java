package eshopping.service;

import eshopping.dao.IProductDao;
import eshopping.domain.Product;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductServiceTest extends BaseServiceTest{
    @Autowired
    private IProductService productService;

    @Before
    public void setUp() {
        cleanUpDB();
    }

    @After
    public void tearDown() {
        //cleanUpDB();
    }

    private void cleanUpDB() {
        productService.deleteAllProduct();
    }

    @Test
    public void testdata(){

        Product product = new Product();
        product.setProductName("MinhSang");
        productService.addProduct(product);
        List<Product> products =  productService.getProductList();
        System.out.print(products.size());
        assertThat(products.size(),equalTo(1));


    }
}
