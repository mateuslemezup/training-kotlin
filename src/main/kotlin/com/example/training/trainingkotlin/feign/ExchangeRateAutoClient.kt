package com.example.training.trainingkotlin.feign

import com.example.training.trainingkotlin.domain.feign.ExchangeClientResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "partner", url = "\${partner.host}")
interface ExchangeRateAutoClient {

    @GetMapping("/v6/latest")
    fun getRate(): ExchangeClientResponse

}