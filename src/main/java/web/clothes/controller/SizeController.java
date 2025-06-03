package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.SizeRequest;
import web.clothes.dto.response.SizeResponse;
import web.clothes.entity.Size;
import web.clothes.mapper.SizeMapper;
import web.clothes.repository.SizeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/size")
@RequiredArgsConstructor
public class SizeController {
    private final SizeRepository sizeRepository;

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<SizeResponse> responseList = sizeRepository.findAll()
                .stream()
                .map(SizeMapper::entityToResponse)
                .toList();
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                responseList,
                null, null, null, null));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody SizeRequest request) {
        Size size = SizeMapper.addRequestToEntity(request);
        SizeResponse response = SizeMapper.entityToResponse(sizeRepository.save(size));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "add success",
                response,
                null, null, null, null));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> addCategory(@RequestBody SizeRequest request, @PathVariable Long id) {
        Size brand = SizeMapper.updateRequestToEntity(request, id);
        SizeResponse response = SizeMapper.entityToResponse(sizeRepository.save(brand));
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "edit success",
                response,
                null, null, null, null));
    }
}
