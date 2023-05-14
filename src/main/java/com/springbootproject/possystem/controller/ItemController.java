package com.springbootproject.possystem.controller;

import com.springbootproject.possystem.dto.CustomerDTO;
import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.dto.request.ItemUpdateDTO;
import com.springbootproject.possystem.dto.response.ItemResponseDTO;
import com.springbootproject.possystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(
            path = {"/save"}
    )
    public String saveItem(@RequestBody ItemDTO itemDTO){
        String message = itemService.saveItem(itemDTO);
        return message;
    }

    @PutMapping(
            path = {"/update"}
    )
    public String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        itemService.updateItem(itemUpdateDTO);
        return "updated";

    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public ItemDTO getItemById(@RequestParam(value = "id") int itemId){
        ItemDTO itemDTO = itemService.getItemById(itemId);
        return itemDTO;
    }
    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemResponseDTO> getItemBnNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemResponseDTO> itemDTO = itemService.getItemBnNameAndStatus(itemName);
        return itemDTO;

    }


}
