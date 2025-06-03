package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.ProductDetailRequest;
import web.clothes.dto.response.ProductDetailResponse;
import web.clothes.service.ProductDetailService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-details")
@RequiredArgsConstructor
public class ProductDetailController {

    private final ProductDetailService productDetailService;

    // Tạo mới chi tiết sản phẩm
    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody ProductDetailRequest request) {
        ProductDetailResponse response = productDetailService.create(request);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "create  success",
                response,
                null, null, null, null));
    }

    // Cập nhật chi tiết sản phẩm
    @PutMapping("edit/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody ProductDetailRequest request) {
        ProductDetailResponse response = productDetailService.update(request, id);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "update  success",
                response,
                null, null, null, null));
    }

    // Lấy danh sách chi tiết sản phẩm theo ProductId
    @GetMapping("/all")
    public ResponseEntity<?> findAllByProductId(@RequestParam Long productId) {
        List<ProductDetailResponse> responses = productDetailService.findAllByProductId(productId);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                responses,
                null, null, null, null));
    }
}





