package com.company.account.service;

import com.company.account.exception.CustomerNotFoundException;
import com.company.account.model.Customer;
import com.company.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    protected Customer findByCustomerId(String id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer note found by id:" + id));
    }

}
