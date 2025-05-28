package web.clothes.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CouponRequest {
    private String code;
    private String name;
    private String describes;
    private LocalDateTime startDay;
    private LocalDateTime endDay;
    private String couponType;
    private BigDecimal couponValue;
    private BigDecimal couponMax;
    private Integer quantity;
    private BigDecimal minimumBill;
}
