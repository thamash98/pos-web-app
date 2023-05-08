package com.springbootproject.possystem.controller;

import com.springbootproject.possystem.dto.CustomerDTO;
import com.springbootproject.possystem.dto.request.CustomerUpdateDTO;
import com.springbootproject.possystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }
     @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message =  customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(
            path = "/get-all-customers"
    )
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String message = customerService.deleteCustomer(customerId);
        return message;
    }
}
