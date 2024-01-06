package com.sprinbootcourse.Pos.dto.pagination;

import com.sprinbootcourse.Pos.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedCustomerDTO {
    private List<CustomerDTO> items;
    private long count;
}

