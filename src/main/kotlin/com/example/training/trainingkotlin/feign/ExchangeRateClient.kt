package com.example.training.trainingkotlin.feign

import com.example.training.trainingkotlin.domain.feign.ExchangeClientResponse
import org.springframework.web.bind.annotation.GetMapping

interface ExchangeRateClient {

    @GetMapping("/v6/latest")
    fun getRate(): ExchangeClientResponse

}