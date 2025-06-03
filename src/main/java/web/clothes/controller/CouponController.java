package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.CouponRequest;
import web.clothes.dto.response.CouponResponse;
import web.clothes.service.CouponService;

@RestController
@RequestMapping("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
                                     @RequestParam(defaultValue = "10", required = false) Integer size) {

        Page<CouponResponse> responses = couponService.findAll(page, size);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                responses.getContent(),
                responses.getNumber(), responses.getSize(), responses.getTotalElements(), responses.getTotalPages()));
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody CouponRequest couponRequest) {
        CouponResponse response = couponService.create(couponRequest);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "create success",
                response,
                null, null, null, null));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody CouponRequest couponRequest) {
        CouponResponse response = couponService.update(couponRequest, id);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "update success",
                response,
                null, null, null, null));
    }
}
