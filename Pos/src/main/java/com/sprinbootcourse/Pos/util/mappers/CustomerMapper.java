package com.sprinbootcourse.Pos.util.mappers;

import com.sprinbootcourse.Pos.dto.CustomerDTO;
import com.sprinbootcourse.Pos.model.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {
    List<CustomerDTO> pageToCustomerDtoList(Page<Customer> customers);
}
