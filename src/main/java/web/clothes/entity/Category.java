package web.clothes.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {
    private String name;
}
