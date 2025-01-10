package com.ecommerce.mapper;

import com.ecommerce.model.Order;
import com.ecommerce.record.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .orderId(request.orderId())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }
}
