package web.clothes.dto.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductDetailResponse {
    private Long id;
    private String code;
    private BigDecimal price;
    private Integer quantity;
    private SizeResponse size;
    private ColorResponse color;
    private String describes;
    private String barcode;
    private ProductResponse product;
    private Integer status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private List<ImageResponse> images;
}
