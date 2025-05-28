package web.clothes.mapper;

import web.clothes.dto.request.ImageRequest;
import web.clothes.dto.response.ImageResponse;
import web.clothes.entity.Image;

public class ImageMapper {
    public static Image addRequestToEntity(ImageRequest request) {
        return Image.builder().url(request.getUrl()).build();
    }

    public static Image updateRequestToEntity(ImageRequest request, Long id) {
        Image image = new Image();
        image.setId(id);
        image.setUrl(request.getUrl());
        return image;
    }

    public static ImageResponse
    entityToResponse(Image entity) {
        return ImageResponse.builder().id(entity.getId()).url(entity.getUrl()).build();
    }
}
