package web.clothes.dto.request;
import lombok.Getter;

@Getter
public class CartDetailRequest {
    private Long cartId;
    private Long productDetailId;
    private Integer quantity;
}
