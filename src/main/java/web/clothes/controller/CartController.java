package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.CartRequest;
import web.clothes.dto.response.CartResponse;
import web.clothes.service.CartService;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        CartResponse response = cartService.findCartByIdCustomer(id);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find cart success",
                response,
                null, null, null, null));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody CartRequest request) {
        CartResponse response = cartService.createCart(request);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "add success",
                response,
                null, null, null, null));
    }
}
