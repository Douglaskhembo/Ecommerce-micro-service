package com.ecommerce.repository;

import com.ecommerce.kafka.payment.PaymentConfirmation;
import com.ecommerce.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
