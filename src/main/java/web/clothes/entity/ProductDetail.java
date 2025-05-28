package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tbl_product_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetail extends BaseEntity {
    private String code;
    private BigDecimal price;
    private Integer quantity;
    private String describes;
    private String barcode;

    @ManyToOne
    @JoinColumn(name = "size_id")
    @JsonManagedReference
    private Size size;

    @ManyToOne
    @JoinColumn(name = "color_id")
    @JsonManagedReference
    private Color color;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    @OneToMany(mappedBy = "productDetail")
    @JsonBackReference
    private List<Image> images;

    @OneToMany(mappedBy = "productDetail")
    @JsonBackReference
    private List<DiscountProduct> discountProducts;

    @OneToMany(mappedBy = "productDetail")
    @JsonBackReference
    private List<CartDetail> cartDetails;

    @OneToMany(mappedBy = "productDetail")
    @JsonBackReference
    private List<BillDetail> billDetails;
}