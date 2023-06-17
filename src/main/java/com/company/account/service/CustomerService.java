package com.company.account.service;

import com.company.account.dto.CustomerDto;
import com.company.account.dto.converter.CustomerDtoConverter;
import com.company.account.exception.CustomerNotFoundException;
import com.company.account.model.Customer;
import com.company.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }


    protected Customer findByCustomerId(String id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer note found by id:" + id));
    }

    public CustomerDto findById(String customerId){
        Customer customer = findByCustomerId(customerId);
        return customerDtoConverter.convertToCustomerDto(customer);
    }

}
