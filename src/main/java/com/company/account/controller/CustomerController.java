package com.company.account.controller;

import com.company.account.dto.CustomerDto;
import com.company.account.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomer")
    public ResponseEntity<CustomerDto> getById(@RequestParam String customerId){
        return ResponseEntity.ok(customerService.findById(customerId));
    }
}
