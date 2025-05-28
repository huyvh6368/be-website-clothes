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
public class CartDetailResponse {
    private Long id;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal moneyAfterDecrease;
    private BigDecimal totalMoney;
    private ProductDetailResponse productDetail;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
