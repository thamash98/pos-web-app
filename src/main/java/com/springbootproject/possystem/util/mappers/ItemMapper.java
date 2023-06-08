package com.springbootproject.possystem.util.mappers;

import com.springbootproject.possystem.dto.response.ItemResponseDTO;
import com.springbootproject.possystem.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemResponseDTO> ListDTOToPage(Page<Item> items);
}
