package com.company.account.dto

import com.company.account.dto.functionalDto.CustomerAccountDto


data class CustomerDto(
    val id: String?,
    val name: String?,
    val surname: String?,
    val accounts: Set<CustomerAccountDto>?
    )
