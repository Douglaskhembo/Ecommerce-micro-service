package com.ecommerce.customer;

public record CustomerResponse(
        String custId,
        String firstName,
        String lastName,
        String email
) {
}
