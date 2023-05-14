package com.springbootproject.possystem.service;

import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.dto.request.ItemUpdateDTO;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    String updateItem(ItemUpdateDTO itemUpdateDTO);
}
