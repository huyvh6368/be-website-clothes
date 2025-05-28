package web.clothes.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "tbl_customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseEntity {
    private String name;
    private Date birthday;
    private String gender;
    private Integer orderCancellationCount;

    @OneToOne
    @JoinColumn(name = "account_id")
    @JsonManagedReference
    private Account account;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<CouponCustomer> couponCustomers;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Bill> bills;

    @OneToOne(mappedBy = "customer")
    @JsonManagedReference
    private Cart cart;
}
