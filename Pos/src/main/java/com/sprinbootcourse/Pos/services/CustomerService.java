package com.sprinbootcourse.Pos.services;

import com.sprinbootcourse.Pos.dto.CustomerDTO;
import com.sprinbootcourse.Pos.dto.pagination.PaginatedCustomerDTO;
import com.sprinbootcourse.Pos.dto.request.UpdateCustomerRQ;

import java.util.List;

public interface CustomerService {

    String saveCustomer (CustomerDTO customerDTO);

    PaginatedCustomerDTO getAllCustomer(int page, int size);

    String updateCustomer(UpdateCustomerRQ updateCustomerRQ);

    CustomerDTO getCustomerById(int id);

    String deleteCustomerById(int id);
}
