package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CouponCustomerResponse {
    private Long id;
    private CouponResponse coupon;
    private CustomerResponse customer;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
