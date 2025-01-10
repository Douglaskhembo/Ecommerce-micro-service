package com.ecommerce.customer;

public record CustomerResponse(
        Integer custId,
        String firstName,
        String lastName,
        String email
) {
}
