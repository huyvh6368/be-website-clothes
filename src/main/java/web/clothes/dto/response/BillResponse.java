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
public class BillResponse {
    private Long id;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private BigDecimal shippingFee;
    private CouponResponse coupon;
    private BigDecimal couponValue;
    private String code;
    private String buyAt;
    private String paymentMethod;
    private AddressResponse address;
    private CustomerResponse customer;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
//    private List<BillDetailResponse> billDetails;
//    private List<BillHistoryResponse> billHistories;
}
