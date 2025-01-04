package com.ecommerce.product.mapper;

import com.ecommerce.category.Category;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.record.ProductPurchaseResponse;
import com.ecommerce.product.record.ProductRequest;
import com.ecommerce.product.record.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .prdId(request.prdId())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(Category.builder().categId(request.categId()).build())
                .build();
    }
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getPrdId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getCategId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurcaseResponse(Product product,double quantity) {
        return new ProductPurchaseResponse(
                product.getPrdId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
