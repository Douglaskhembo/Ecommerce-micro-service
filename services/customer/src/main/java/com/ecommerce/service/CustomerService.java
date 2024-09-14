package com.ecommerce.service;

import com.ecommerce.records.CustomerRequest;

public interface CustomerService {
    String createCustomer(CustomerRequest request);
    void updateCustomer(CustomerRequest request);
}
