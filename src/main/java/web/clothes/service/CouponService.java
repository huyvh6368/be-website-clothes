package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.CouponRequest;
import web.clothes.dto.response.CouponResponse;
import web.clothes.entity.Coupon;
import web.clothes.mapper.CouponMapper;
import web.clothes.repository.CouponRepository;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public CouponResponse create(CouponRequest couponRequest) {
        Coupon coupon = couponRepository.save(CouponMapper.addRequestToEntity(couponRequest));
        return CouponMapper.entityToResponse(coupon);
    }

    public CouponResponse update(CouponRequest couponRequest, Long id) {
        Coupon coupon = couponRepository.save(CouponMapper.updateRequestToEntity(couponRequest, id));
        return CouponMapper.entityToResponse(coupon);
    }

    public Page<CouponResponse> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Coupon> coupons = couponRepository.findAll(pageable);
        return coupons.map(CouponMapper::entityToResponse);
    }
}
