package com.company.account.dto.requests

import java.math.BigDecimal

data class CreateAccountRequest(
    val customerId: String?,
    val initialCredit: BigDecimal?
){

}
