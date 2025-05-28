package web.clothes.mapper;

import web.clothes.dto.request.ProductRequest;
import web.clothes.dto.response.BrandResponse;
import web.clothes.dto.response.CategoryResponse;
import web.clothes.dto.response.ProductResponse;
import web.clothes.entity.Brand;
import web.clothes.entity.Category;
import web.clothes.entity.Product;

public class ProductMapper {
    public static Product addRequestToEntity(ProductRequest request, Brand brand, Category category) {
        return Product.builder()
                .code(request.getCode())
                .name(request.getName())
                .price(request.getPrice())
                .describes(request.getDescribes())
                .brand(brand)
                .category(category)
                .image(request.getImage())
                .build();
    }

    public static Product updateRequestToEntity(ProductRequest request, Brand brand, Category category, Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDescribes(request.getDescribes());
        product.setBrand(brand);
        product.setCategory(category);
        product.setImage(request.getImage());
        return product;
    }

    public static ProductResponse entityToResponse(Product entity, CategoryResponse categoryResponse, BrandResponse brandResponse) {
        return ProductResponse.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .price(entity.getPrice())
                .describes(entity.getDescribes())
                .brand(brandResponse)
                .category(categoryResponse)
                .image(entity.getImage())
                .build();
    }
}
