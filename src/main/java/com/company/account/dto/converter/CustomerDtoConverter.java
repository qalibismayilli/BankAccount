package com.company.account.dto.converter;

import com.company.account.dto.CustomerDto;
import com.company.account.dto.functionalDto.AccountCustomerDto;
import com.company.account.model.Customer;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private final AccountDtoConverter accountDtoConverter;

    public CustomerDtoConverter(AccountDtoConverter accountDtoConverter){
        this.accountDtoConverter = accountDtoConverter;
    }

    public CustomerDto convertToCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerDto(customer.getId(), customer.getName(), customer.getSurname()
                ,customer.getAccounts().stream()
                .map(a -> accountDtoConverter.convertToCustomerAccountDto(a)).collect(Collectors.toSet()));

    }

    public AccountCustomerDto convertToAccountCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new AccountCustomerDto(customer.getId(), customer.getName(), customer.getSurname());
    }
}
