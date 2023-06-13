package com.company.account.service;

import com.company.account.dto.AccountDto;
import com.company.account.dto.converter.AccountDtoConverter;
import com.company.account.dto.requests.CreateAccountRequest;
import com.company.account.model.Account;
import com.company.account.model.Customer;
import com.company.account.model.Transaction;
import com.company.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private  final AccountDtoConverter accountDtoConverter;


    public AccountService(AccountRepository accountRepository
            , CustomerService customerService
            , TransactionService transactionService
            , AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findByCustomerId(createAccountRequest.getCustomerId());

        Account account = new Account(customer, createAccountRequest.getInitialCredit(), LocalDateTime.now());

        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){
            Transaction transaction = transactionService.initiateMoney(account,account.getBalance());
            account.getTransactions().add(transaction);
        }
        Account account1 = accountRepository.save(account);
        return accountDtoConverter.convertToAccountDto(account1);
    }
}
