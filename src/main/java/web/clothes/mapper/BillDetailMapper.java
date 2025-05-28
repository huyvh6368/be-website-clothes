package web.clothes.mapper;

import web.clothes.dto.request.BillDetailRequest;
import web.clothes.dto.response.BillDetailResponse;
import web.clothes.dto.response.DiscountCampaignResponse;
import web.clothes.dto.response.ProductDetailResponse;
import web.clothes.entity.BillDetail;
import web.clothes.entity.DiscountCampaign;
import web.clothes.entity.ProductDetail;

public class BillDetailMapper {
    public static BillDetail addRequestToEntity(BillDetailRequest request, ProductDetail productDetail, DiscountCampaign discountCampaign) {
        return BillDetail.builder()
                .productDetail(productDetail)
                .discountCampaign(discountCampaign)
                .price(request.getPrice())
                .moneyAfterDecrease(request.getMoneyAfterDecrease())
                .quantity(request.getQuantity())
                .build();
    }

    public static BillDetail updateRequestToEntity(BillDetailRequest request, ProductDetail productDetail, DiscountCampaign discountCampaign, Long id) {
        BillDetail billDetail = new BillDetail();
        billDetail.setProductDetail(productDetail);
        billDetail.setDiscountCampaign(discountCampaign);
        billDetail.setPrice(request.getPrice());
        billDetail.setMoneyAfterDecrease(request.getMoneyAfterDecrease());
        billDetail.setQuantity(request.getQuantity());
        billDetail.setId(id);
        return billDetail;
    }

    public static BillDetailResponse entityToResponse(BillDetail entity, ProductDetailResponse productDetailResponse, DiscountCampaignResponse discountCampaignResponse) {
        return BillDetailResponse.builder()
                .productDetail(productDetailResponse)
                .discountCampaign(discountCampaignResponse)
                .price(entity.getPrice())
                .moneyAfterDecrease(entity.getMoneyAfterDecrease())
                .quantity(entity.getQuantity())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .build();
    }
}
