package com.springbootproject.possystem.service;

import com.springbootproject.possystem.dto.CustomerDTO;
import com.springbootproject.possystem.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();
}
