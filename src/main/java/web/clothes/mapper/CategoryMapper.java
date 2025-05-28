package web.clothes.mapper;

import web.clothes.dto.request.CategoryRequest;
import web.clothes.dto.response.CategoryResponse;
import web.clothes.entity.Category;

public class CategoryMapper {

    public static Category addRequestToEntity(CategoryRequest request) {
        return Category.builder().name(request.getName()).build();
    }

    public static Category updateRequestToEntity(CategoryRequest request, Long id) {
        Category category = new Category();
        category.setId(id);
        category.setName(request.getName());
        return category;
    }

    public static CategoryResponse entityToResponse(Category entity) {
        return CategoryResponse.builder().id(entity.getId()).name(entity.getName()).build();
    }
}
