package com.springbootproject.possystem.service;

import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.dto.request.ItemUpdateDTO;
import com.springbootproject.possystem.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    ItemDTO getItemById(int itemId);

    List<ItemResponseDTO> getItemBnNameAndStatus(String itemName);
}
