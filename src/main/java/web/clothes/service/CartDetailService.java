package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.CartDetailRequest;
import web.clothes.dto.response.CartDetailResponse;
import web.clothes.entity.Cart;
import web.clothes.entity.CartDetail;
import web.clothes.entity.ProductDetail;
import web.clothes.repository.CartDetailRepository;
import web.clothes.repository.CartRepository;
import web.clothes.repository.ProductDetailRepository;
import web.clothes.util.CartDetailStatus;
import web.clothes.util.FinalCode;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartDetailService {
    private final CartService cartService;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final ProductDetailRepository productDetailRepository;

    // add to cart
    public Integer addToCartDetail(CartDetailRequest request) {
        Optional<CartDetail> check = cartDetailRepository.findCartDetailByCartIdAndProductId(
                request.getCartId(), request.getProductDetailId());
        if (check.isPresent()) {
            // Nếu đã có, cập nhật số lượng
            CartDetail existingDetail = check.get();
            existingDetail.setQuantity(existingDetail.getQuantity() + request.getQuantity());
            cartDetailRepository.save(existingDetail);
            return FinalCode.UPDATE_SUCCESS_STATUS;
        } else {
            // Nếu chưa có, thêm mới
            CartDetail newDetail = new CartDetail();
            Cart cart = cartRepository.findById(request.getCartId())
                    .orElseThrow(() -> new RuntimeException("cart not found"));
            ProductDetail productDetail = productDetailRepository.findById(request.getProductDetailId())
                    .orElseThrow(() -> new RuntimeException("product not found"));
            newDetail.setCart(cart);
            newDetail.setStatus(CartDetailStatus.DISPLAY);
            newDetail.setProductDetail(productDetail);
            newDetail.setQuantity(request.getQuantity());
            cartDetailRepository.save(newDetail);
            return FinalCode.ADD_SUCCESS_STATUS;
        }
    }

    public List<CartDetailResponse> findAll(Long cartId) {
        List<CartDetail> cartDetails = cartDetailRepository.findCartDetailByCartId(cartId);
        return null;
    }
}
