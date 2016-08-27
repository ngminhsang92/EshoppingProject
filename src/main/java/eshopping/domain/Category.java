package eshopping.domain;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    private String categoryName;

    private String categoryDescription;

    @Transient
    private MultipartFile coverImage;

    @Lob
    @Column(length = 100000)
    //@Cache(usage=CacheConcurrencyStrategy.NONE)
    //@JsonIgnore
    private Blob imagebytes;
}
