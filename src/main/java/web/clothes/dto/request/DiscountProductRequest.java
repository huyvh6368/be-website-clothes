package web.clothes.dto.request;
import lombok.Getter;

@Getter
public class DiscountProductRequest {
    private Long discountId;
    private Long productDetailId;
}
