package web.clothes.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "tbl_bill_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDetail extends BaseEntity {
    private BigDecimal price;
    private BigDecimal moneyAfterDecrease;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonManagedReference
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    @JsonManagedReference
    private ProductDetail productDetail;

    @ManyToOne
    @JoinColumn(name = "discount_campaign_id")
    @JsonManagedReference
    private DiscountCampaign discountCampaign;
}