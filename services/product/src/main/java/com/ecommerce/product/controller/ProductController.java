package com.ecommerce.product.controller;

import com.ecommerce.product.record.ProductPurchaseResponse;
import com.ecommerce.product.record.ProductRequest;
import com.ecommerce.product.record.ProductResponse;
import com.ecommerce.product.record.ProductPurchaseRequest;
import com.ecommerce.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/protected/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Integer>createProduct(
            @RequestBody @Valid ProductRequest request)
    {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> productPurchase(
            @RequestBody List<ProductPurchaseRequest> request)
    {
        return ResponseEntity.ok(productService.purchaseProduct(request));
    }

    @GetMapping("/findProduct/{productId}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("productId") Integer prdId)
    {
        return ResponseEntity.ok(productService.findById(prdId));
    }

    @GetMapping("findAllProduct")
    public ResponseEntity<List<ProductResponse>>findAll()
    {
        return ResponseEntity.ok(productService.findAll());
    }


}
