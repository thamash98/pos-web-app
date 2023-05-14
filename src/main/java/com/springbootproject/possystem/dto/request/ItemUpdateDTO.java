package com.springbootproject.possystem.dto.request;

import com.springbootproject.possystem.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemUpdateDTO {
    private int itemId;

    private String itemName;


    private double qtyOnHand;

    private double supplierPrice;

    private double sellingPrice;
}
