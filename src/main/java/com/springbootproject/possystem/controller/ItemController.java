package com.springbootproject.possystem.controller;

import com.springbootproject.possystem.dto.CustomerDTO;
import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/save")
    public String saveItem(@RequestBody ItemDTO itemDTO){
        String message = itemService.saveItem(itemDTO);
        return message;
    }
}
