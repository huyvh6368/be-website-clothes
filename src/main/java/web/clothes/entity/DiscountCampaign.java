package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_discount_campaign")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscountCampaign extends BaseEntity {
    private String code;
    private String name;
    private String describes;
    private LocalDateTime startDay;
    private LocalDateTime endDay;
    private String discountType;
    private BigDecimal discountValue;
    private BigDecimal discountMax;

    @OneToMany(mappedBy = "discount")
    @JsonBackReference
    private List<DiscountProduct> discountProducts;

    @OneToMany(mappedBy = "discountCampaign")
    @JsonBackReference
    private List<BillDetail> billDetails;

}
