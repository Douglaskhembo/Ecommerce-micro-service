package com.ecommerce.service;

import com.ecommerce.mapper.PaymentMapper;
import com.ecommerce.record.PaymentRequest;
import com.ecommerce.repository.PaymentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    public Integer createPayment(@Valid PaymentRequest paymentRequest) {
        var payment = repository.save(mapper.toPayment(paymentRequest));
        return null;
    }
}
