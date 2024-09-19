package com.ecommerce.service;

import com.ecommerce.records.CustomerRequest;
import com.ecommerce.records.CustomerResponse;

import java.util.List;

public interface CustomerService {
    String createCustomer(CustomerRequest request);
    void updateCustomer(CustomerRequest request);
    List<CustomerResponse> findAllCustomers();
}
