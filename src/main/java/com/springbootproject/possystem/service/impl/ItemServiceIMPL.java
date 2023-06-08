package com.springbootproject.possystem.service.impl;

import com.springbootproject.possystem.dto.ItemDTO;
import com.springbootproject.possystem.dto.paginated.PaginatedResponseItemDTO;
import com.springbootproject.possystem.dto.request.ItemUpdateDTO;
import com.springbootproject.possystem.dto.response.ItemResponseDTO;
import com.springbootproject.possystem.exception.NotFoundException;
import com.springbootproject.possystem.entity.Item;
import com.springbootproject.possystem.repo.ItemRepo;
import com.springbootproject.possystem.service.ItemService;
import com.springbootproject.possystem.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemDTO itemDTO) {
        Item item = modelMapper.map(itemDTO,Item.class);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "saved Item";
        }else {
            return "Already Exist";
        }
    }

    @Override
    public String updateItem(ItemUpdateDTO itemUpdateDTO) {
        if (itemRepo.existsById(itemUpdateDTO.getItemId())){
            Item item = itemRepo.getReferenceById(itemUpdateDTO.getItemId());
            item.setItemName(itemUpdateDTO.getItemName());
            item.setQtyOnHand(itemUpdateDTO.getQtyOnHand());
            item.setSupplierPrice(itemUpdateDTO.getSupplierPrice());
            item.setSellingPrice(itemUpdateDTO.getSellingPrice());
            itemRepo.save(item);
            return "update Successful";
        }else {
            return "Item not found";
        }

    }

    @Override
    public ItemDTO getItemById(int itemId) {
        if (itemRepo.existsById(itemId)){
            Item item = itemRepo.getReferenceById(itemId);
            ItemDTO itemDTO = modelMapper.map(item,ItemDTO.class);
            return itemDTO;
        }else{
            throw new RuntimeException("Item not found");
        }
    }

    @Override
    public List<ItemResponseDTO> getItemByNameAndStatus(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, true);
        if(items.size() > 0){
            List<ItemResponseDTO> itemResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemResponseDTO>>(){}.getType());
            return itemResponseDTOS;
        }else {
            throw new RuntimeException("Item in out of stock");
        }
    }

   /* @Override
    public List<ItemResponseDTO> getItemByActiveStatus(boolean activeStatus) {
        List<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus);
        if(items.size() > 0){
            List<ItemResponseDTO> itemResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemResponseDTO>>(){}.getType());
            return itemResponseDTOS;
        }else {
            throw new NotFoundException("No Active Status Items found");
        }
    }*/

    @Override
    public PaginatedResponseItemDTO getItemByActiveStatusWithPaginated(boolean activeStatus, int page, int size) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeStatus, PageRequest.of(page,size));
        if (items.getSize()<1){
            throw new NotFoundException("No Data");
        }
        PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                itemMapper.ListDTOToPage(items),
                itemRepo.countAllByActiveStateEquals(activeStatus)
        );

        return paginatedResponseItemDTO;
    }
}
