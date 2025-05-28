package web.clothes.dto.request;
import lombok.Getter;

@Getter
public class CouponCustomerRequest {
    private Long couponId;
    private Long customerId;
}
