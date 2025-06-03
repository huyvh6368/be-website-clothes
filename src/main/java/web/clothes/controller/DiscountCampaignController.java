package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.DiscountCampaignRequest;
import web.clothes.dto.response.DiscountCampaignResponse;
import web.clothes.service.DiscountCampaignService;

@RestController
@RequestMapping("/api/v1/discount")
@RequiredArgsConstructor
public class DiscountCampaignController {
    private final DiscountCampaignService discountCampaignService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0", required = false) Integer page,
                                     @RequestParam(defaultValue = "10", required = false) Integer size) {
        Page<DiscountCampaignResponse> responses = discountCampaignService.findAll(page, size);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "find all success",
                responses.getContent(),
                responses.getNumber(), responses.getSize(), responses.getTotalElements(), responses.getTotalPages()));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody DiscountCampaignRequest request) {
        DiscountCampaignResponse response = discountCampaignService.create(request);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "create success",
                response,
                null, null, null, null));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DiscountCampaignRequest request) {
        DiscountCampaignResponse response = discountCampaignService.update(request, id);
        return ResponseEntity.ok(new ResponseData<>(HttpStatus.OK.value(),
                "update success",
                response,
                null, null, null, null));
    }
}
