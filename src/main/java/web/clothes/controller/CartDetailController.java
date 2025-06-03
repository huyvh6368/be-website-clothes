package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.CartDetailRequest;
import web.clothes.service.CartDetailService;

@RestController
@RequestMapping("/api/v1/cart-detail")
@RequiredArgsConstructor
public class CartDetailController {
    private final CartDetailService cartDetailService;

    // current have done create cart detail
    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartDetailRequest request) {
        Integer code = cartDetailService.addToCartDetail(request);
        return ResponseEntity.ok(new ResponseData<>(
                code,
                "success",
                null,
                null, null, null, null));
    }
}
