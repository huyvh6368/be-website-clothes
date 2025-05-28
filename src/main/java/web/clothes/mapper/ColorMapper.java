package web.clothes.mapper;

import web.clothes.dto.request.ColorRequest;
import web.clothes.dto.response.ColorResponse;
import web.clothes.entity.Color;

public class ColorMapper {
    public static Color addRequestToEntity(ColorRequest request) {

        return Color.builder().name(request.getName()).build();
    }

    public static Color updateRequestToEntity(ColorRequest request, Long id) {
        Color color = new Color();
        color.setId(id);
        color.setName(request.getName());
        return color;
    }

    public static ColorResponse entityToResponse(Color entity) {
        return ColorResponse.builder().id(entity.getId()).name(entity.getName()).build();
    }
}
