package web.clothes.dto.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BillRequest {
    private Long couponId;
    private Long addressId;
    private Long customerId;
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private BigDecimal shippingFee;
    private BigDecimal couponValue;
    private String code;
    private String paymentMethod;
    private String buyAt;
//    private List<BillDetailRequest> billDetails;
}
