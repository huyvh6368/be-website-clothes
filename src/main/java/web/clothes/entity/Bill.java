package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tbl_bill")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bill extends BaseEntity {
    private BigDecimal totalPrice;
    private Integer totalQuantity;
    private BigDecimal shippingFee;
    private BigDecimal couponValue;
    private String buyAt;
    private String code;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    @JsonManagedReference
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonManagedReference
    private Address address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    @JsonBackReference
    private List<BillDetail> billDetails;

    @OneToMany(mappedBy = "bill")
    @JsonBackReference
    private List<BillHistory> billHistories;
}
