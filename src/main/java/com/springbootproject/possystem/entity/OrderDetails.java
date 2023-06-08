package com.springbootproject.possystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {
    @Id
    @Column(name="order_details_id",length = 255)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderDetailsId;

    @Column(name="item_name", length = 100, nullable = false)
    private String itemName;

    @Column(name="qty", nullable = false)
    private double qty;

    @Column(name = "amount", nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item items;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;
}
