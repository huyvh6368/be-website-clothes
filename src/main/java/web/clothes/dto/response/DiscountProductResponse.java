package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DiscountProductResponse {
    private Long id;
    private DiscountCampaignResponse discount;
    private ProductDetailResponse productDetail;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
