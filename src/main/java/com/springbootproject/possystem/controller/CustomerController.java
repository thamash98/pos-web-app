package com.springbootproject.possystem.controller;

import com.springbootproject.possystem.dto.CustomerDTO;
import com.springbootproject.possystem.dto.request.CustomerUpdateDTO;
import com.springbootproject.possystem.service.CustomerService;
import com.springbootproject.possystem.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO){
        String message = customerService.saveCustomer(customerDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Save Success", message),
                HttpStatus.CREATED
        );
    }
     @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message =  customerService.updateCustomer(customerUpdateDTO);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Updated",message),
                HttpStatus.OK);
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse> getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",customerDTO),
                HttpStatus.OK);
    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",allCustomers),
                HttpStatus.OK);
    }

    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable(value = "id") int customerId){
        String message = customerService.deleteCustomer(customerId);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",message),
                HttpStatus.OK);
    }

    @GetMapping(
            path = "/get-all-customers-by-active-state/{status}"
    )
    public ResponseEntity<StandardResponse> getAllCustomersByActiveState(@PathVariable(value = "status") boolean activeState){
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"Success",allCustomers),
                HttpStatus.OK);
    }

}
