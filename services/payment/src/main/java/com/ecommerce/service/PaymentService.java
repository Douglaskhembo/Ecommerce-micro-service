package com.ecommerce.service;

import com.ecommerce.record.PaymentRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    public Integer createPayment(@Valid PaymentRequest paymentRequest) {
        return null;
    }
}
