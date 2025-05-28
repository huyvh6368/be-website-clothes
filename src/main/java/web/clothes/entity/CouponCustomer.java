package web.clothes.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_coupon_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponCustomer extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    @JsonManagedReference
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;
}