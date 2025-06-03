package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.BrandRequest;
import web.clothes.dto.request.ColorRequest;
import web.clothes.dto.response.BrandResponse;
import web.clothes.dto.response.ColorResponse;
import web.clothes.entity.Brand;
import web.clothes.entity.Color;
import web.clothes.mapper.BrandMapper;
import web.clothes.mapper.ColorMapper;
import web.clothes.repository.ColorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/color")
@RequiredArgsConstructor
public class ColorController {
    private final ColorRepository colorRepository;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<ColorResponse> responseList = colorRepository.findAll()
                .stream()
                .map(ColorMapper::entityToResponse)
                .toList();
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                responseList,
                null, null, null, null));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody ColorRequest request) {
        Color color = ColorMapper.addRequestToEntity(request);

        ColorResponse response = ColorMapper.entityToResponse(colorRepository.save(color));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "add success",
                response,
                null, null, null, null));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> addCategory(@RequestBody ColorRequest request, @PathVariable Long id) {
        Color color = ColorMapper.updateRequestToEntity(request, id);
        ColorResponse response = ColorMapper.entityToResponse(colorRepository.save(color));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "edit success",
                response,
                null, null, null, null));
    }
}
