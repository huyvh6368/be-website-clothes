package web.clothes.dto.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductDetailRequest {
    private String code;
    private BigDecimal price;
    private Integer quantity;
    private Long sizeId;
    private Long colorId;
    private String describes;
    private String barcode;
    private Long productId;
}
