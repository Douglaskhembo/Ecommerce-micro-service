package com.ecommerce.repository;

import com.ecommerce.orderLine.OrderLine;
import com.ecommerce.record.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findByOrderLineId(Integer orderLineId);
}
