package com.company.account.dto.converter;

import com.company.account.dto.TransactionDto;
import com.company.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    private final AccountDtoConverter accountDtoConverter;

    public TransactionDtoConverter(AccountDtoConverter accountDtoConverter) {
        this.accountDtoConverter = accountDtoConverter;
    }

    public TransactionDto convertToTransactionDto(Transaction transaction) {
        if (transaction == null) {
            return null;
        }

        return new TransactionDto(transaction.getId(), transaction.getTransactionType(),
                transaction.getAmount(), transaction.getTransactionDate()
                ,accountDtoConverter.convertToAccountDto(transaction.getAccount()));
    }
}
