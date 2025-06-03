package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.ProductRequest;
import web.clothes.dto.response.BrandResponse;
import web.clothes.dto.response.CategoryResponse;
import web.clothes.dto.response.ProductResponse;
import web.clothes.entity.Brand;
import web.clothes.entity.Category;
import web.clothes.entity.Product;
import web.clothes.mapper.BrandMapper;
import web.clothes.mapper.CategoryMapper;
import web.clothes.mapper.ProductMapper;
import web.clothes.repository.BrandRepository;
import web.clothes.repository.CategoryRepository;
import web.clothes.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    public Page<ProductResponse> findAll(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> productPage = productRepository.findAll(pageable);

        List<ProductResponse> productResponses = productPage.getContent().stream()
                .map(product -> {
                    // Mapping từng phần liên quan
                    CategoryResponse categoryResponse = CategoryMapper.entityToResponse(product.getCategory());
                    BrandResponse brandResponse = BrandMapper.entityToResponse(product.getBrand());
                    // Trả về ProductResponse
                    return ProductMapper.entityToResponse(product, categoryResponse, brandResponse);
                })
                .toList();

        return new PageImpl<>(productResponses, pageable, productPage.getTotalElements());
    }

    public ProductResponse createProduct(ProductRequest request) {
        // Lấy brand và category theo ID
        Brand brand = brandRepository.findById(request.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        Category category = categoryRepository.findById(request.getCategoriesId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Tạo entity từ request
        Product product = ProductMapper.addRequestToEntity(request, brand, category);

        // Lưu vào DB
        Product savedProduct = productRepository.save(product);

        // Chuyển sang response
        return ProductMapper.entityToResponse(
                savedProduct,
                CategoryMapper.entityToResponse(savedProduct.getCategory()),
                BrandMapper.entityToResponse(savedProduct.getBrand())
        );
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        // Kiểm tra sản phẩm tồn tại
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Lấy brand và category mới
        Brand brand = brandRepository.findById(request.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        Category category = categoryRepository.findById(request.getCategoriesId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Cập nhật entity từ request
        Product updatedProduct = ProductMapper.updateRequestToEntity(request, brand, category, id);

        // Lưu vào DB
        Product savedProduct = productRepository.save(updatedProduct);

        // Chuyển sang response
        return ProductMapper.entityToResponse(
                savedProduct,
                CategoryMapper.entityToResponse(savedProduct.getCategory()),
                BrandMapper.entityToResponse(savedProduct.getBrand())
        );
    }


}
