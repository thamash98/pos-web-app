package com.springbootproject.possystem.service;

import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.dto.paginated.PaginatedResponseItemDTO;
import com.springbootproject.possystem.dto.request.ItemUpdateDTO;
import com.springbootproject.possystem.dto.response.ItemResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemDTO itemDTO);

    String updateItem(ItemUpdateDTO itemUpdateDTO);

    ItemDTO getItemById(int itemId);

    List<ItemResponseDTO> getItemByNameAndStatus(String itemName);

    //List<ItemResponseDTO> getItemByActiveStatus(boolean activeStatus);

    PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size);
}
