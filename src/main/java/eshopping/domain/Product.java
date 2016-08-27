package eshopping.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Blob;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @NotEmpty(message = "The product name must not be empty")
    private String productName;

    @ManyToOne
    @JoinColumn(name="category_id")
    private String category;

    private String productDescription;

    @Min(value = 0, message = "The product price must not be less then zero")
    private double productPrice;
    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less then zero")
    private int unitInStock;
    private String productManufacturer;

    @Transient
    //@Cache(usage=CacheConcurrencyStrategy.NONE)
   // @JsonIgnore
    private MultipartFile productImage;

    @Lob
    @Column(length = 100000)
    //@Cache(usage=CacheConcurrencyStrategy.NONE)
    //@JsonIgnore
    private Blob imagebytes;

    //@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   // @JsonIgnore
   // private List<CartItem> cartItemList;
}
