package com.ecommerce.record;

import com.ecommerce.customer.CustomerResponse;
import com.ecommerce.enumeration.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
