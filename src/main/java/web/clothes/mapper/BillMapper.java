package web.clothes.mapper;

import web.clothes.dto.request.BillRequest;
import web.clothes.dto.response.AddressResponse;
import web.clothes.dto.response.BillResponse;
import web.clothes.dto.response.CouponResponse;
import web.clothes.dto.response.CustomerResponse;
import web.clothes.entity.Address;
import web.clothes.entity.Bill;
import web.clothes.entity.Coupon;
import web.clothes.entity.Customer;

public class BillMapper {
    public static Bill addRequestToEntity(BillRequest request, Address address, Customer customer, Coupon coupon) {
        return Bill.builder()
                .coupon(coupon)
                .customer(customer)
                .address(address)
                .shippingFee(request.getShippingFee())
                .couponValue(request.getCouponValue())
                .buyAt(request.getBuyAt())
                .code(request.getCode())
                .paymentMethod(request.getPaymentMethod())
                .shippingFee(request.getShippingFee())
                .couponValue(request.getCouponValue())
                .build();
    }

    public static Bill updateRequestToEntity(BillRequest request, Address address, Customer customer, Coupon coupon, Long id) {
        Bill bill = new Bill();
        bill.setId(id);
        bill.setAddress(address);
        bill.setCustomer(customer);
        bill.setCoupon(coupon);
        bill.setShippingFee(request.getShippingFee());
        bill.setCouponValue(request.getCouponValue());
        bill.setBuyAt(request.getBuyAt());
        bill.setCode(request.getCode());
        bill.setPaymentMethod(request.getPaymentMethod());
        bill.setShippingFee(request.getShippingFee());
        bill.setTotalPrice(request.getTotalPrice());
        bill.setTotalQuantity(request.getTotalQuantity());
        return bill;
    }

    public static BillResponse entityToResponse(Bill entity, AddressResponse address, CustomerResponse customer, CouponResponse coupon) {
        if (entity == null) return null;

        return BillResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .paymentMethod(entity.getPaymentMethod())
                .buyAt(entity.getBuyAt())
                .shippingFee(entity.getShippingFee())
                .couponValue(entity.getCouponValue())
                .coupon(coupon)
                .address(address)
                .customer(customer)
                .totalPrice(entity.getTotalPrice())
                .totalQuantity(entity.getTotalQuantity())
                .status(entity.getStatus())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                // Nếu bạn muốn map cả danh sách chi tiết hóa đơn hoặc lịch sử thì mở comment dưới:
                // .billDetails(billDetailResponses)
                // .billHistories(billHistoryResponses)
                .build();
    }

}
