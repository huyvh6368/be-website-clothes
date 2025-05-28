package web.clothes.dto.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BillDetailRequest {
    private Long productDetailId;
    private Long discountCampaignId;
    private BigDecimal price;
    private BigDecimal moneyAfterDecrease;
    private Integer quantity;
}
