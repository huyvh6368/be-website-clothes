package web.clothes.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BillDetailResponse {
    private Long id;
    private BigDecimal price;
    private BigDecimal moneyAfterDecrease;
    private Integer quantity;
    private ProductDetailResponse productDetail;
    private DiscountCampaignResponse discountCampaign;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
