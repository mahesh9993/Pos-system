package com.sprinbootcourse.Pos.controller;

import com.sprinbootcourse.Pos.dto.CustomerDTO;
import com.sprinbootcourse.Pos.dto.pagination.PaginatedCustomerDTO;
import com.sprinbootcourse.Pos.dto.request.UpdateCustomerRQ;
import com.sprinbootcourse.Pos.services.CustomerService;
import com.sprinbootcourse.Pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/saveCustomer")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO){

        String response = this.customerService.saveCustomer(customerDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"customer saved",response),HttpStatus.CREATED
        ) ;
    }

    @GetMapping(
            path = "/getAllCustomers",
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllCustomer(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        PaginatedCustomerDTO paginatedCustomerDTO = this.customerService.getAllCustomer(page,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Customers",paginatedCustomerDTO), HttpStatus.OK);
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<StandardResponse> getCustomerById(@PathVariable(value = "id") int id){
        CustomerDTO customerDTO = this.customerService.getCustomerById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Customer Found",customerDTO),HttpStatus.OK
        );
    }


    @PutMapping("/updateCustomer")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody UpdateCustomerRQ updateCustomerRQ){
        String response = this.customerService.updateCustomer(updateCustomerRQ);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"update customer",response),HttpStatus.OK
        );
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value = "id") int id){
        String response = this.customerService.deleteCustomerById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"delete customer",response),HttpStatus.OK
        );    }

}
