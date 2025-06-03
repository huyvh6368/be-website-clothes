package web.clothes.controller;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.CategoryRequest;
import web.clothes.dto.response.CategoryResponse;
import web.clothes.entity.Category;
import web.clothes.mapper.CategoryMapper;
import web.clothes.repository.CategoryRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;


    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<CategoryResponse> responseList = categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::entityToResponse)
                .toList();
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                responseList,
                null, null, null, null));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest categoryRequest) {
        Category category = CategoryMapper.addRequestToEntity(categoryRequest);

        CategoryResponse response = CategoryMapper.entityToResponse(categoryRepository.save(category));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "add success",
                response,
                null, null, null, null));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> addCategory(@RequestBody CategoryRequest request, @PathVariable Long id) {
        Category category = CategoryMapper.updateRequestToEntity(request, id);
        CategoryResponse response = CategoryMapper.entityToResponse(categoryRepository.save(category));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "add success",
                response,
                null, null, null, null));
    }

}
