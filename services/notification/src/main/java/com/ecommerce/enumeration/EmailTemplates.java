package com.ecommerce.enumeration;

import lombok.Getter;

public enum EmailTemplates {

    PAYMENT_CONFIRMATION("Payment-confirmation.html", "Payment Successfully processed"),
    ORDER_CONFIRMATION("Order-confirmation.html", "Order Confirmation");

    @Getter
    private final String template;

    @Getter
    private final String subject;

    EmailTemplates(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
