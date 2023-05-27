package com.springbootproject.possystem.dto.paginated;

import com.springbootproject.possystem.dto.response.ItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    List<ItemResponseDTO> list;
    private long dataCount;

}
