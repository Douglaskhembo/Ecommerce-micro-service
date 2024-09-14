package com.ecommerce.controller;

import com.ecommerce.records.CustomerRequest;
import com.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("protected/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }
}
