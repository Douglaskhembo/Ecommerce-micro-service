package com.ecommerce.kafka.order;

public record Customer(
        String custId,
        String firstName,
        String lastName,
        String email
) {
}
