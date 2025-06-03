package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.ProductRequest;
import web.clothes.dto.response.ProductResponse;
import web.clothes.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // Tạo mới sản phẩm
    @PostMapping("/add")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        ProductResponse response = productService.createProduct(request);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "add success",
                response,
                null, null, null, null));
    }

    // Cập nhật sản phẩm
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        ProductResponse response = productService.updateProduct(id, request);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "edit success",
                response,
                null, null, null, null));
    }

    // find all
    @GetMapping("/all")
    public ResponseEntity<?> findAll(@RequestParam(value = "0", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        Page<ProductResponse> response = productService.findAll(page, size);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                response.getContent(),
                response.getNumber(), response.getSize(), response.getTotalElements(), response.getTotalPages()));
    }
}
