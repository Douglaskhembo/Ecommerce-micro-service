package com.ecommerce.records;

import com.ecommerce.module.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
