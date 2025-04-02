package com.ecommerce.record;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String custId,

        @NotNull(message = "first name is required")
        String firstName,

        @NotNull(message = "last name is required")
        String lastName,

        @NotNull(message = "email name is required")
        @Email(message = "The customer email is not correctly formatted")
        String email
) {
}
