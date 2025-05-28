package web.clothes.mapper;

import web.clothes.dto.request.BannerRequest;
import web.clothes.dto.response.BannerResponse;
import web.clothes.entity.Banner;

public class BannerMapper {
    public static Banner addRequestToEntity(BannerRequest request) {
        return Banner.builder().url(request.getUrl()).defaulted(request.getDefaulted()).build();
    }

    public static Banner updateRequestToEntity(BannerRequest request, Long id) {
        Banner banner = new Banner();
        banner.setId(id);
        banner.setUrl(request.getUrl());
        banner.setDefaulted(request.getDefaulted());
        return banner;
    }

    public static BannerResponse entityToResponse(Banner entity) {
        return BannerResponse.builder()
                .id(entity.getId())
                .url(entity.getUrl())
                .defaulted(entity.getDefaulted())
                .createDate(entity.getCreateDate())
                .updateDate(entity.getUpdateDate())
                .build();
    }
}
