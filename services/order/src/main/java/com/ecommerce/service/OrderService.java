package com.ecommerce.service;

import com.ecommerce.customer.CustomerClient;
import com.ecommerce.exceptions.BusinessException;
import com.ecommerce.kafka.OrderConfirmation;
import com.ecommerce.kafka.OrderProducer;
import com.ecommerce.mapper.OrderMapper;
import com.ecommerce.orderLine.OrderLineService;
import com.ecommerce.product.ProductClient;
import com.ecommerce.product.PurchaseRequest;
import com.ecommerce.record.OrderLineRequest;
import com.ecommerce.record.OrderRequest;
import com.ecommerce.record.OrderResponse;
import com.ecommerce.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepo;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createdOrder(OrderRequest request) {
        // Check if customer exist -- Customer-service (FeignClient)
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer not found with ID:: " + request.customerId()));

        //Purchase product -- product-service (RestTemplate)
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //persist order
        var order = this.orderRepo.save(mapper.toOrder(request));
        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getOrderId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        //payment process implementation

        //sending order confirmation - kafka
        orderProducer.senderOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getOrderId();
    }


    public List<OrderResponse> findAllOrders() {
        return orderRepo.findAll()
                .stream()
                .map(mapper:: fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepo.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with provided id:: %d", orderId)));
    }
}
