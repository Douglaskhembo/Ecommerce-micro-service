package com.ecommerce.service.Impl;

import com.ecommerce.records.CustomerRequest;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public String createCustomer(CustomerRequest request) {
        return null;
    }
}
