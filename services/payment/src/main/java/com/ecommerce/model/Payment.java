package com.ecommerce.model;

import com.ecommerce.enumeration.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_payment")
public class Payment {

    @Id
    @GeneratedValue
    @Column(name = "payment_id")
    private Integer payId;

    @Column(name = "payment_amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_order")
    private Integer orderId;
    @CreatedDate
    @Column(name = "payment_date", updatable = false, nullable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(name = "payment_update_date", insertable = false)
    private LocalDate lastModifiedDate;
}
