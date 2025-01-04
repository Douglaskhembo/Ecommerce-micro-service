package com.ecommerce.product.service;

import com.ecommerce.product.record.ProductPurchaseResponse;
import com.ecommerce.product.record.ProductRequest;
import com.ecommerce.product.record.ProductResponse;
import com.ecommerce.product.record.ProductPurchaseRequest;

import java.util.List;

public interface ProductService {
    Integer createProduct(ProductRequest request);

    List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request);

    ProductResponse findById(Integer prdId);

    List<ProductResponse> findAll();
}
