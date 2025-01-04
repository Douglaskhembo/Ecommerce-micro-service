package com.ecommerce.product.service.impl;

import com.ecommerce.exception.ProductPurchaseException;
import com.ecommerce.product.mapper.ProductMapper;
import com.ecommerce.product.record.ProductPurchaseResponse;
import com.ecommerce.product.record.ProductRequest;
import com.ecommerce.product.record.ProductResponse;
import com.ecommerce.product.record.ProductPurchaseRequest;
import com.ecommerce.product.repository.ProductRespository;
import com.ecommerce.product.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRespository productRepo;
    private final ProductMapper productMapper;

    @Override
    public Integer createProduct(ProductRequest request) {
        var product = productMapper.toProduct(request);
        return productRepo.save(product).getPrdId();
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) {
        var productIds = request.stream()
                .map(ProductPurchaseRequest::prdId)
                .toList();
        var storedProducts = productRepo.findAllByPrdIdInOrderByPrdId(productIds);
        if (storedProducts.size() != productIds.size()) {
            throw new ProductPurchaseException("One or more products does not is out of stoke");
        }

        var storedRequests = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::prdId))
                .toList();
        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for(int i = 0; i< storedProducts.size(); i++){
            var product = storedProducts.get(i);
            var productRequest = storedRequests.get(i);
            if (product.getAvailableQuantity() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient quantity for product with ID:: " +productRequest.prdId());
            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            productRepo.save(product);
            purchasedProducts.add(productMapper.toProductPurcaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

    @Override
    public ProductResponse findById(Integer prdId) {

        return productRepo.findById(prdId)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with ID:: " + prdId));
    }

    @Override
    public List<ProductResponse> findAll() {

        return productRepo.findAll()
                .stream().map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
