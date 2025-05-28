package web.clothes.mapper;

import web.clothes.dto.request.SizeRequest;
import web.clothes.dto.response.SizeResponse;
import web.clothes.entity.Size;

public class SizeMapper {
    public static Size addRequestToEntity(SizeRequest request) {
        return Size.builder().name(request.getName()).build();
    }

    public static Size updateRequestToEntity(SizeRequest request, Long id) {
        Size size = new Size();
        size.setId(id);
        size.setName(request.getName());
        return size;
    }

    public static SizeResponse entityToResponse(Size entity) {
        return SizeResponse.builder().id(entity.getId()).name(entity.getName()).build();
    }
}
