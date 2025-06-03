package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.BrandRequest;
import web.clothes.dto.response.BrandResponse;
import web.clothes.entity.Brand;
import web.clothes.mapper.BrandMapper;
import web.clothes.repository.BrandRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brand")
@RequiredArgsConstructor
public class BrandController {
    private final BrandRepository brandRepository;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<BrandResponse> responseList = brandRepository.findAll()
                .stream()
                .map(BrandMapper::entityToResponse)
                .toList();
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                responseList,
                null, null, null, null));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody BrandRequest request) {
        Brand brand = BrandMapper.addRequestToEntity(request);

        BrandResponse response = BrandMapper.entityToResponse(brandRepository.save(brand));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "add success",
                response,
                null, null, null, null));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> addCategory(@RequestBody BrandRequest request, @PathVariable Long id) {
        Brand brand = BrandMapper.updateRequestToEntity(request, id);
        BrandResponse response = BrandMapper.entityToResponse(brandRepository.save(brand));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "edit success",
                response,
                null, null, null, null));
    }
}
