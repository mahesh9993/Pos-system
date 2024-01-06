package com.sprinbootcourse.Pos.dto.pagination;

import com.sprinbootcourse.Pos.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedItemDTO {
    private List<ItemDTO> items;
    private long count;
}
