package web.clothes.mapper;

import web.clothes.dto.request.CartDetailRequest;
import web.clothes.dto.response.CartDetailResponse;
import web.clothes.dto.response.ProductDetailResponse;
import web.clothes.dto.response.ProductResponse;
import web.clothes.entity.Cart;
import web.clothes.entity.CartDetail;
import web.clothes.entity.ProductDetail;

import java.math.BigDecimal;

public class CartDetailMapper {
    public static CartDetail addRequestToEntity(CartDetailRequest request, Cart cart, ProductDetail productDetail) {
        return CartDetail.builder()
                .cart(cart)
                .productDetail(productDetail)
                .quantity(request.getQuantity())
                .build();
    }

    public static CartDetail updateRequestToEntity(CartDetailRequest request, Cart cart, ProductDetail productDetail, Long id) {
        CartDetail cartDetail = new CartDetail();
        cartDetail.setId(id);
        cartDetail.setCart(cart);
        cartDetail.setProductDetail(productDetail);
        cartDetail.setQuantity(request.getQuantity());
        return cartDetail;
    }

    public static CartDetailResponse entityToResponse(CartDetail entity,
                                                      ProductDetailResponse productResponse,
                                                      BigDecimal moneyAfterDecrease,
                                                      BigDecimal totalMoney
    ) {
        return CartDetailResponse.builder()
                .id(entity.getId())
                .productDetail(productResponse)
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .moneyAfterDecrease(moneyAfterDecrease)
                .totalMoney(totalMoney)
                .build();
    }
}
