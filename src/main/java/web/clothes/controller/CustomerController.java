package web.clothes.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.clothes.dto.ResponseData;
import web.clothes.dto.request.CustomerRequest;
import web.clothes.dto.response.CustomerResponse;
import web.clothes.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody CustomerRequest customerRequest) {
        CustomerResponse response = customerService.create(customerRequest);
        return ResponseEntity.ok(new ResponseData<>(
                HttpStatus.OK.value(),
                "success",
                response,
                null, null, null, null));
    }
}
