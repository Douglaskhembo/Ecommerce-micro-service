package com.ecommerce.controller;

import com.ecommerce.module.Customer;
import com.ecommerce.records.CustomerRequest;
import com.ecommerce.records.CustomerResponse;
import com.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("protected/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        String createCustomer = customerService.createCustomer(request);
        return ResponseEntity.ok(createCustomer);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<CustomerResponse>> getAllCustomers(){
        List<CustomerResponse> customerResponses = customerService.findAllCustomers();
        return ResponseEntity.ok(customerResponses);
    }

    @GetMapping("/existCustomer/{custId}")
    public ResponseEntity<Boolean> existById(@PathVariable("custId") Long customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @GetMapping("/findCustomer/{custId}")
    public ResponseEntity<CustomerResponse> findCustomerById(@PathVariable("custId") Long customerId){
        return ResponseEntity.ok(customerService.findCustomerById(customerId));
    }

    @DeleteMapping("/deleteCustomer/{custId}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("custId") Long customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.accepted().build();
    }
}
