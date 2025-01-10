package com.ecommerce.service;

import com.ecommerce.record.OrderRequest;

public interface OrderService {
    Integer createdOrder(OrderRequest request);
}
