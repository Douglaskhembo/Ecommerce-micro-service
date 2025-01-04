package com.ecommerce.product.record;

import java.math.BigDecimal;

public record ProductPurchaseResponse(
        Integer prdId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
