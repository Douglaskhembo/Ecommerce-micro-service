package com.ecommerce.controller;


import com.ecommerce.orderLine.OrderLineService;
import com.ecommerce.record.OrderLineResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/protected/orderLines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{orderLine-id}")
    public ResponseEntity<List<OrderLineResponse>> getOrderLineById(
            @PathVariable("orderLine-id") Integer orderLineId
    ){
        return ResponseEntity.ok(orderLineService.findByOrderLineId(orderLineId));
    }
}
