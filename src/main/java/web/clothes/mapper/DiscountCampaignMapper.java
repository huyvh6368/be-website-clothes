package web.clothes.mapper;

import web.clothes.dto.request.DiscountCampaignRequest;
import web.clothes.dto.response.DiscountCampaignResponse;
import web.clothes.entity.DiscountCampaign;
import web.clothes.util.DiscountStatus;

public class DiscountCampaignMapper {
    public static DiscountCampaign addRequestToEntity(DiscountCampaignRequest request) {
        DiscountCampaign discountCampaign = new DiscountCampaign();
        discountCampaign.setCode(request.getCode());
        discountCampaign.setName(request.getName());
        discountCampaign.setDescribes(request.getDescribes());
        discountCampaign.setStartDay(request.getStartDay());
        discountCampaign.setEndDay(request.getEndDay());
        discountCampaign.setDiscountType(request.getDiscountType());
        discountCampaign.setDiscountValue(request.getDiscountValue());
        discountCampaign.setDiscountMax(request.getDiscountMax());
        discountCampaign.setStatus(DiscountStatus.SAP_DIEN_RA);
        return discountCampaign;
    }

    public static DiscountCampaign updateRequestToEntity(DiscountCampaignRequest request, Long id) {
        DiscountCampaign discountCampaign = new DiscountCampaign();
        discountCampaign.setId(id);
        discountCampaign.setCode(request.getCode());
        discountCampaign.setName(request.getName());
        discountCampaign.setDescribes(request.getDescribes());
        discountCampaign.setStartDay(request.getStartDay());
        discountCampaign.setEndDay(request.getEndDay());
        discountCampaign.setDiscountType(request.getDiscountType());
        discountCampaign.setDiscountValue(request.getDiscountValue());
        discountCampaign.setDiscountMax(request.getDiscountMax());
        discountCampaign.setStatus(request.getStatus());
        return discountCampaign;
    }

    public static DiscountCampaignResponse entityToResponse(DiscountCampaign entity) {
        return DiscountCampaignResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .describes(entity.getDescribes())
                .startDay(entity.getStartDay())
                .endDay(entity.getEndDay())
                .discountType(entity.getDiscountType())
                .discountType(entity.getDiscountType())
                .discountValue(entity.getDiscountValue())
                .discountMax(entity.getDiscountMax())
                .status(entity.getStatus())
                .build();
    }
}
