package com.sprinbootcourse.Pos.services.impl;

import com.sprinbootcourse.Pos.dto.CustomerDTO;
import com.sprinbootcourse.Pos.dto.pagination.PaginatedCustomerDTO;
import com.sprinbootcourse.Pos.dto.request.UpdateCustomerRQ;
import com.sprinbootcourse.Pos.exception.NotFoundException;
import com.sprinbootcourse.Pos.model.Customer;
import com.sprinbootcourse.Pos.repo.CustomerRepo;
import com.sprinbootcourse.Pos.services.CustomerService;
import com.sprinbootcourse.Pos.util.mappers.CustomerMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {

        Customer customer = this.modelMapper.map(customerDTO,Customer.class);

        this.customerRepo.save(customer);

        return customer.getCustomerName()+" saved";
    }

    @Override
    public PaginatedCustomerDTO getAllCustomer(int page, int size) {
        Page<Customer> customers = this.customerRepo.findAll(PageRequest.of(page, size));

        if (customers.getTotalElements()>0){
            return new PaginatedCustomerDTO(
                    this.customerMapper.pageToCustomerDtoList(customers),
                    this.customerRepo.count()
            );
        }else {
            throw new NotFoundException("customers not found");
        }
    }

    @Override
    public String updateCustomer(UpdateCustomerRQ updateCustomerRQ) {

        if(this.customerRepo.existsByCustomerIdEquals(updateCustomerRQ.getCustomerId())) {
            Customer customer = this.customerRepo.getReferenceById(updateCustomerRQ.getCustomerId());

            customer.setCustomerName(updateCustomerRQ.getCustomerName());
            customer.setCustomerAddress(updateCustomerRQ.getCustomerAddress());
            customer.setContactNumbers(updateCustomerRQ.getContactNumbers());

            this.customerRepo.saveAndFlush(customer);

            return customer.getCustomerName() + " updated";
        }else {
            throw new NotFoundException("customers not found for update");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Customer customer = this.customerRepo.getReferenceById(id);
        if (customer.getCustomerId() != 0){
            CustomerDTO customerDTO = this.modelMapper.map(customer,CustomerDTO.class);
            return customerDTO;
        }else {
            throw new NotFoundException("customer not found");
        }

    }

    @Override
    public String deleteCustomerById(int id) {
        if(this.customerRepo.existsByCustomerIdEquals(id)){
            Customer customer = this.customerRepo.getReferenceById(id);
            this.customerRepo.deleteById(id);

            return customer.getCustomerName() + " successfully deleted";
        }else{
            throw new NotFoundException("customer not found for delete");
        }
    }
}
