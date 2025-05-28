package web.clothes.mapper;

import web.clothes.dto.request.BrandRequest;
import web.clothes.dto.response.BrandResponse;
import web.clothes.entity.Brand;

public class BrandMapper {
    public static Brand addRequestToEntity(BrandRequest request) {
        return Brand.builder().name(request.getName()).build();
    }

    public static Brand updateRequestToEntity(BrandRequest request, Long id) {
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(request.getName());
        return brand;
    }

    public static BrandResponse entityToResponse(Brand entity) {
        return BrandResponse.builder().id(entity.getId()).name(entity.getName()).build();
    }
}
