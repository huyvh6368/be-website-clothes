package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "tbl_bill_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillHistory extends BaseEntity {
    private String userAction;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonManagedReference
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;
}
