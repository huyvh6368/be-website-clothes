package web.clothes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.clothes.dto.request.ProductDetailRequest;
import web.clothes.dto.response.ColorResponse;
import web.clothes.dto.response.ProductDetailResponse;
import web.clothes.dto.response.SizeResponse;
import web.clothes.entity.*;
import web.clothes.mapper.ColorMapper;
import web.clothes.mapper.ProductDetailMapper;
import web.clothes.mapper.ProductMapper;
import web.clothes.mapper.SizeMapper;
import web.clothes.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailService {
    private final ProductDetailRepository productDetailRepository;
    private final ProductRepository productRepository;
    private final SizeRepository sizeRepository;
    private final ColorRepository colorRepository;


    public ProductDetailResponse create(ProductDetailRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Color color = colorRepository.findById(request.getColorId())
                .orElseThrow(() -> new RuntimeException("Color not found"));
        Size size = sizeRepository.findById(request.getSizeId())
                .orElseThrow(() -> new RuntimeException("Size not found"));
        ProductDetail entity = ProductDetailMapper.addRequestToEntity(request, product, color, size);
        entity.setStatus(1);
        entity.setCreateDate(LocalDateTime.now());

        ProductDetail saved = productDetailRepository.save(entity);

        return ProductDetailMapper.entityToResponse(
                saved,
                product,
                ColorMapper.entityToResponse(color),
                SizeMapper.entityToResponse(size),
                null
        );
    }

    public ProductDetailResponse update(ProductDetailRequest request, Long id) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        Color color = colorRepository.findById(request.getColorId())
                .orElseThrow(() -> new RuntimeException("Color not found"));
        Size size = sizeRepository.findById(request.getSizeId())
                .orElseThrow(() -> new RuntimeException("Size not found"));
        // kiểm tra xem id tồn tại ko
        productDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("product detail not found"));

        ProductDetail entity = ProductDetailMapper.addRequestToEntity(request, product, color, size);
        entity.setStatus(1);
        entity.setCreateDate(LocalDateTime.now());

        ProductDetail saved = productDetailRepository.save(entity);

        return ProductDetailMapper.entityToResponse(
                saved,
                product,
                ColorMapper.entityToResponse(color),
                SizeMapper.entityToResponse(size),
                null
        );
    }

    public List<ProductDetailResponse> findAllByProductId(Long id) {
        List<ProductDetailResponse> responses = productDetailRepository.findByProductId(id).stream().map(item -> {
            ColorResponse colorResponse = ColorMapper.entityToResponse(item.getColor());
            SizeResponse sizeResponse = SizeMapper.entityToResponse(item.getSize());
            return ProductDetailMapper.entityToResponse(item, item.getProduct(), colorResponse, sizeResponse, null);
        }).toList();
        return responses;
    }
}
