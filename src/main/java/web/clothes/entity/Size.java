package web.clothes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_size")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Size extends BaseEntity {
    private String name;
}
