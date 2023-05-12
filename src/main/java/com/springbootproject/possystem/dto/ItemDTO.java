package com.springbootproject.possystem.dto;

import com.springbootproject.possystem.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private int itemId;

    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double qtyOnHand;

    private double supplierPrice;

    private double sellingPrice;

    private boolean activeState;

}
