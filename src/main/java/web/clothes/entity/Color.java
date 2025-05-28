package web.clothes.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tbl_color")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Color extends BaseEntity {
    private String name;
}
