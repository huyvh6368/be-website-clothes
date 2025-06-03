package web.clothes.mapper;

import web.clothes.dto.request.ProductDetailRequest;
import web.clothes.dto.response.*;
import web.clothes.entity.Color;
import web.clothes.entity.Product;
import web.clothes.entity.ProductDetail;
import web.clothes.entity.Size;

import java.util.List;

public class ProductDetailMapper {
    public static ProductDetail addRequestToEntity(ProductDetailRequest request, Product product, Color color, Size size) {
        return ProductDetail.builder()
                .code(request.getCode())
                .describes(request.getDescribes())
                .barcode(request.getBarcode())
                .color(color)
                .product(product)
                .size(size)
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .build();
    }

    public static ProductDetail updateRequestToEntity(ProductDetailRequest request, Product product, Color color, Size size, Long id) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(id);
        productDetail.setCode(request.getCode());
        productDetail.setPrice(request.getPrice());
        productDetail.setDescribes(request.getDescribes());
        productDetail.setBarcode(request.getBarcode());
        productDetail.setQuantity(request.getQuantity());
        productDetail.setProduct(product);
        productDetail.setSize(size);
        productDetail.setColor(color);
        return productDetail;
    }

    public static ProductDetailResponse entityToResponse(ProductDetail entity,
                                                         Product product,
                                                         ColorResponse colorResponse,
                                                         SizeResponse sizeResponse,
                                                         List<ImageResponse> imagesResponse
    ) {
        return ProductDetailResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .describes(entity.getDescribes())
                .barcode(entity.getBarcode())
                .color(colorResponse)
                .productId(product.getId())
                .productName(product.getName())
                .size(sizeResponse)
                .price(entity.getPrice())
                .quantity(entity.getQuantity())
                .images(imagesResponse)
                .build();
    }
}
