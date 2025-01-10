package com.ecommerce.service.impl;

import com.ecommerce.customer.CustomerClient;
import com.ecommerce.exceptions.BusinessException;
import com.ecommerce.mapper.OrderMapper;
import com.ecommerce.orderLine.OrderLineService;
import com.ecommerce.product.ProductClient;
import com.ecommerce.product.PurchaseRequest;
import com.ecommerce.record.OrderLineRequest;
import com.ecommerce.record.OrderRequest;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepo;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;
    @Override
    public Integer createdOrder(OrderRequest request) {
        // Check if customer exist -- Customer-service (FeignClient)
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No Customer not found with ID:: " + request.customerId()));

        //Purchase product -- product-service (RestTemplate)
        this.productClient.purchaseProducts(request.products());

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

        return null;
    }
}
