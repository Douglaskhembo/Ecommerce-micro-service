package com.ecommerce.product.record;

import java.math.BigDecimal;

public record ProductResponse(
        Integer prdId,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categId,
        String categoryName,
        String categoryDescription
) {
}
