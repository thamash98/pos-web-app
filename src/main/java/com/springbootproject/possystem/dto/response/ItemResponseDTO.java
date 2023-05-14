package com.springbootproject.possystem.dto.response;

import com.springbootproject.possystem.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemResponseDTO {
    private int itemId;

    private String itemName;

    private double qtyOnHand;

    private double supplierPrice;

    private double sellingPrice;

    private boolean activeState;
}
