package com.springbootproject.possystem.service.impl;

import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.entity.Item;
import com.springbootproject.possystem.repo.ItemRepo;
import com.springbootproject.possystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String saveItem(ItemDTO itemDTO) {
        Item item = new Item(
                itemDTO.getItemId(),
                itemDTO.getItemName(),
                itemDTO.getMeasuringUnitType(),
                itemDTO.getQtyOnHand(),
                itemDTO.getSupplierPrice(),
                itemDTO.getSellingPrice(),
                itemDTO.isActiveState()
        );
        itemRepo.save(item);
        return "saved Item";
    }
}
