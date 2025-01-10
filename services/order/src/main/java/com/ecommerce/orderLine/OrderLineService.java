package com.ecommerce.orderLine;

import com.ecommerce.mapper.MapperOrderLine;
import com.ecommerce.repository.OrderLineRepository;
import com.ecommerce.record.OrderLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final MapperOrderLine mapperOrderLine;

    public Integer saveOrderLine(OrderLineRequest request) {
        var order = mapperOrderLine.toOrderLine(request);
        return orderLineRepository.save(order).getId();
    }
}
