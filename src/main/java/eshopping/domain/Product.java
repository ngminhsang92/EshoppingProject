package eshopping.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.sql.Blob;

@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -3532377236419382983L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty(message = "The product name must not be empty")
    private String productName;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    private String productDescription;

    @Min(value = 0, message = "The product price must not be less then zero")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less then zero")
    private int unitInStock;
    private String productManufacturer;

    @Transient
   // @JsonIgnore
    private MultipartFile productImage;

    @Lob
    @Column(length = 100000)
    //@JsonIgnore
    private Blob imagebytes;

    //@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   // @JsonIgnore
   // private List<CartItem> cartItemList;


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public Blob getImagebytes() {
        return imagebytes;
    }

    public void setImagebytes(Blob imagebytes) {
        this.imagebytes = imagebytes;
    }
}
