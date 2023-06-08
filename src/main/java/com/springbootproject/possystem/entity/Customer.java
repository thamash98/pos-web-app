package com.springbootproject.possystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 200)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;
}
