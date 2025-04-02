package com.ecommerce.records;

import com.ecommerce.model.Address;

public record CustomerResponse(
        String cust_id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
