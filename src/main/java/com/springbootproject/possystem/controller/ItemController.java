package com.springbootproject.possystem.controller;

import com.springbootproject.possystem.dto.CustomerDTO;
import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.dto.request.ItemUpdateDTO;
import com.springbootproject.possystem.dto.response.ItemResponseDTO;
import com.springbootproject.possystem.service.ItemService;
import com.springbootproject.possystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDTO itemDTO){
        String message = itemService.saveItem(itemDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<>(
                new StandardResponse(201,"Save Successfully",message),
                HttpStatus.CREATED);
        return response;
    }

    @PutMapping(
            path = {"/update"}
    )
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String message = itemService.updateItem(itemUpdateDTO);
        return new ResponseEntity<>(
                new StandardResponse(201,"Updated Successfully",message),
                HttpStatus.CREATED);
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getItemById(@RequestParam(value = "id") int itemId){
        ItemDTO itemDTO = itemService.getItemById(itemId);
        return  new ResponseEntity<>(
                new StandardResponse(200,"Success",itemDTO),
                HttpStatus.OK
        );
    }
    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemBnNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemResponseDTO> itemDTO = itemService.getItemBnNameAndStatus(itemName);
        return  new ResponseEntity<>(
                new StandardResponse(200,"Success",itemDTO),
                HttpStatus.OK
        );

    }


}
