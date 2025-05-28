package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account extends BaseEntity {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private User user;
    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private Customer customer;
}
