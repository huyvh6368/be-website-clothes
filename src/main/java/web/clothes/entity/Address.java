package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbl_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends BaseEntity {
    private String receiver;
    private String phoneNumber;
    private String province;
    private String district;
    private String ward;
    private String address;
    private Boolean addressDefault;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    @OneToMany(mappedBy = "address")
    @JsonBackReference
    private List<Bill> bills;
}