package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_cart_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDetail extends BaseEntity {
    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonManagedReference
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    @JsonManagedReference
    private ProductDetail productDetail;
}
