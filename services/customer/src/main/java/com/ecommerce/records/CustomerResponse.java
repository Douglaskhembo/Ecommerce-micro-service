package com.ecommerce.records;

import com.ecommerce.model.Address;

public record CustomerResponse(
        Long cust_id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
