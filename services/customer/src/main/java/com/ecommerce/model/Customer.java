package com.ecommerce.model;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Document
public class Customer {

    @Id
    private Long cust_id;
    @Column(name = "cust_first_name")
    private String firstName;
    @Column(name = "cust_last_name")
    private String lastName;
    @Column(name = "cust_email")
    private String email;
    @Column(name = "cust_address")
    private Address address;
}
