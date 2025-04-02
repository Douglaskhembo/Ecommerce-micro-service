package com.ecommerce.mapper;

import com.ecommerce.model.Order;
import com.ecommerce.orderLine.OrderLine;
import com.ecommerce.record.OrderLineRequest;
import com.ecommerce.record.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class MapperOrderLine {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .quantity(request.quantity())
                .productId(request.productId())
                .order(Order.builder().orderId(request.orderId()).build())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
