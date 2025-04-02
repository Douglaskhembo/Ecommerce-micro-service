package com.ecommerce.record;

import com.ecommerce.enumeration.PaymentMethod;

import java.math.BigDecimal;

public record OrderResponse(
        Integer orderId,
        String reference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
