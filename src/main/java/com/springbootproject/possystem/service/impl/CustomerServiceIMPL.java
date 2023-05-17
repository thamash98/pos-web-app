package com.springbootproject.possystem.service.impl;

import com.springbootproject.possystem.dto.CustomerDTO;
import com.springbootproject.possystem.dto.request.CustomerUpdateDTO;
import com.springbootproject.possystem.entity.Customer;
import com.springbootproject.possystem.exception.NotFoundException;
import com.springbootproject.possystem.repo.CustomerRepo;
import com.springbootproject.possystem.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        customerRepo.save(customer);
        return "Saved";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customerRepo.save(customer);

            return "updated customer";
        }else {
            throw new NotFoundException("Customer Id Not Found");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
            return customerDTO;
        }else {
            throw new NotFoundException("Customer Not Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer: allCustomers) {
            CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
            customerDTOList.add(customerDTO);
        }
        
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return customerId+" deleted successfully";
        }else {
            return "Customer not found in that Id";
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> allCustomers = customerRepo.findAllByActiveStateEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer: allCustomers) {
            CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
            customerDTOList.add(customerDTO);
        }

        return customerDTOList;
    }
}
