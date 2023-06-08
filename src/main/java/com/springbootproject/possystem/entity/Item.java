package com.springbootproject.possystem.entity;

import com.springbootproject.possystem.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @Column(name="item_id",length = 255)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name="item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type", length = 50, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name="qty_on_hand", nullable = false)
    private double qtyOnHand;

    @Column(name="supplier_price", nullable = false)
    private double supplierPrice;

    @Column(name ="selling_price",nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy = "items")
    private List<OrderDetails> orderDetails;
}
