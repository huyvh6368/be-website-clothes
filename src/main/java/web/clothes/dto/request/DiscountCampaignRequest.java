package web.clothes.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class DiscountCampaignRequest {
    private String code;
    private String name;
    private String describes;
    private LocalDateTime startDay;
    private LocalDateTime endDay;
    private String discountType;
    private BigDecimal discountValue;
    private BigDecimal discountMax;
    private Integer status;
}
