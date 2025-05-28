package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_discount_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountProduct extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "discount_id")
    @JsonManagedReference
    private DiscountCampaign discount;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    @JsonManagedReference
    private ProductDetail productDetail;
}
