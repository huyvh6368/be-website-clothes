package web.clothes.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tbl_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    @JsonBackReference
    private List<CartDetail> cartDetails;
}
