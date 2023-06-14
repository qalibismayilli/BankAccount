package com.company.account.dto.converter;

import com.company.account.dto.functionalDto.CustomerAccountDto;
import com.company.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account account){
        return new CustomerAccountDto(account.getId()
                , account.getBalance(),account.getCreationDate(), account.getTransactions().stream()
                .map(t->transactionDtoConverter.convertToTransactionDto(t)).collect(Collectors.toSet()));
    }
}
