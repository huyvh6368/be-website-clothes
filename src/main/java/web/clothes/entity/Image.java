package web.clothes.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "tbl_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image extends BaseEntity {
    private String url;
    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    @JsonManagedReference
    private ProductDetail productDetail;
}
