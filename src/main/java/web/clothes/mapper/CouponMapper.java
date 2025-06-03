package web.clothes.mapper;

import web.clothes.dto.request.CouponRequest;
import web.clothes.dto.response.CouponResponse;
import web.clothes.entity.Coupon;
import web.clothes.util.DiscountStatus;

public class CouponMapper {
    public static Coupon addRequestToEntity(CouponRequest request) {
//        return Coupon.builder()
//                .code(request.getCode())
//                .name(request.getName())
//                .describes(request.getDescribes())
//                .startDay(request.getStartDay())
//                .endDay(request.getEndDay())
//                .couponType(request.getCouponType())
//                .couponValue(request.getCouponValue())
//                .couponMax(request.getCouponMax())
//                .quantity(request.getQuantity())
//                .status()
//                .minimumBill(request.getMinimumBill())
//                .build();

        Coupon coupon = new Coupon();
        coupon.setCode(request.getCode());
        coupon.setName(request.getName());
        coupon.setDescribes(request.getDescribes());
        coupon.setStartDay(request.getStartDay());
        coupon.setEndDay(request.getEndDay());
        coupon.setCouponType(request.getCouponType());
        coupon.setCouponValue(request.getCouponValue());
        coupon.setCouponMax(request.getCouponMax());
        coupon.setQuantity(request.getQuantity());
        coupon.setStatus(DiscountStatus.SAP_DIEN_RA); // dùng tạm
        return coupon;
    }

    public static Coupon updateRequestToEntity(CouponRequest request, Long id) {
        Coupon coupon = new Coupon();
        coupon.setId(id);
        coupon.setCode(request.getCode());
        coupon.setName(request.getName());
        coupon.setDescribes(request.getDescribes());
        coupon.setStartDay(request.getStartDay());
        coupon.setEndDay(request.getEndDay());
        coupon.setCouponType(request.getCouponType());
        coupon.setCouponValue(request.getCouponValue());
        coupon.setCouponMax(request.getCouponMax());
        coupon.setQuantity(request.getQuantity());
        coupon.setStatus(DiscountStatus.SAP_DIEN_RA); // dùng tạm
        coupon.setMinimumBill(request.getMinimumBill());
        return coupon;
    }

    public static CouponResponse entityToResponse(Coupon entity) {
        return CouponResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .describes(entity.getDescribes())
                .startDay(entity.getStartDay())
                .endDay(entity.getEndDay())
                .couponType(entity.getCouponType())
                .couponValue(entity.getCouponValue())
                .couponMax(entity.getCouponMax())
                .quantity(entity.getQuantity())
                .status(entity.getStatus())
                .minimumBill(entity.getMinimumBill())
                .build();
    }
}
