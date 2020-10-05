package com.example.training.trainingkotlin.domain.api

import com.example.training.trainingkotlin.domain.service.Exchange
import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class RequestAPIReq(
    @field:[NotNull Min(0)]
    val amount: BigDecimal?
){
    fun toExchange() = Exchange(amount = this.amount!!)
}