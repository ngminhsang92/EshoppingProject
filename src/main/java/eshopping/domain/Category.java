package eshopping.domain;

import eshopping.controller.ProductController;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.spi.ProviderUtil;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = -3532377336419382983L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    @NotEmpty(message = "The category name must not be empty")
    private String categoryName;

    private String categoryDescription;

    @Transient
    private MultipartFile coverImage;

    @Lob
    @Column(length = 100000)
    //@JsonIgnore
    private Blob imagebytes;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public MultipartFile getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(MultipartFile coverImage) {
        this.coverImage = coverImage;
    }

    public Blob getImagebytes() {
        return imagebytes;
    }

    public void setImagebytes(Blob imagebytes) {
        this.imagebytes = imagebytes;
    }

//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
//
//    public void addProduct(Product product){
//        productList.add(product);
//        product.setCategory(this);
//    }
//    public void removeProduct(Product product){
//        product.setCategory(null);
//        productList.remove(product);
//    }
}
