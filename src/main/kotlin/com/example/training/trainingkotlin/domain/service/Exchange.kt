package com.example.training.trainingkotlin.domain.service

import com.example.training.trainingkotlin.domain.api.RequestAPIRes
import java.math.BigDecimal

data class Exchange(val amount: BigDecimal) {
    fun toRequestApiRes() = RequestAPIRes(amount = this.amount)
}