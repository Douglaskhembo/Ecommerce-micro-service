package com.ecommerce.record;

public record OrderLineResponse(
        Integer orderId,
        double quantity
) {
}
