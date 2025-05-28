package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_coupon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon extends BaseEntity {
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

    @OneToMany(mappedBy = "coupon")
    @JsonBackReference
    private List<CouponCustomer> couponCustomers;

    @OneToMany(mappedBy = "coupon")
    @JsonBackReference
    private List<Bill> bills;
}
