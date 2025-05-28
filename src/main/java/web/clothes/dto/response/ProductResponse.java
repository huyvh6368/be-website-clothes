package web.clothes.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductResponse {
    private Long id;
    private String code;
    private String name;
    private Double price;
    private String describes;
    private CategoryResponse category;
    private BrandResponse brand;
    private String image;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
