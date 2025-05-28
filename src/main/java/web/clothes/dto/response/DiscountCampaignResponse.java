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
public class DiscountCampaignResponse {
    private Long id;
    private String code;
    private String name;
    private String describes;
    private LocalDateTime startDay;
    private LocalDateTime endDay;
    private String discountType;
    private BigDecimal discountValue;
    private BigDecimal discountMax;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
