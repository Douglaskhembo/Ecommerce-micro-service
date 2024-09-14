package com.ecommerce.repository;

import com.ecommerce.module.Customer;
import com.ecommerce.records.CustomerRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
}
