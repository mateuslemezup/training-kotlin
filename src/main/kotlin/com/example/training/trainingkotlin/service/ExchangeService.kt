package com.example.training.trainingkotlin.service

import com.example.training.trainingkotlin.domain.service.Exchange
import java.math.BigDecimal

interface ExchangeService {

    fun fromBrlToUsd(exchange: Exchange): Exchange

    fun saveLog(brlAmount: BigDecimal, usdAmount: BigDecimal)

}