package com.ecommerce.controller;

import com.ecommerce.record.OrderRequest;
import com.ecommerce.record.OrderResponse;
import com.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/protected/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request) {
        return ResponseEntity.ok(orderService.createdOrder(request));
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAllOrders());
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponse> getOrderById(
            @PathVariable("order-id") Integer orderId
    ){
        return ResponseEntity.ok(orderService.findById(orderId));
    }
}
