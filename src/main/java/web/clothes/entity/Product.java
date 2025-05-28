package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbl_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    private String code;
    private String name;
    private Double price;
    private String describes;
    private String image;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    @JsonManagedReference
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @JsonManagedReference
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<ProductDetail> productDetails;
}
