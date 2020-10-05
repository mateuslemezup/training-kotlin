package com.example.training.trainingkotlin.api.impl

import com.example.training.trainingkotlin.api.ExchangeAPI
import com.example.training.trainingkotlin.domain.api.RequestAPIReq
import com.example.training.trainingkotlin.domain.api.RequestAPIRes
import com.example.training.trainingkotlin.service.ExchangeService
import org.springframework.web.bind.annotation.RestController

@RestController
class ExchangeAPIImpl(val exchangeService: ExchangeService): ExchangeAPI {

    override fun apiConverterFromRealToDolar(exchangeAPIReq: RequestAPIReq): RequestAPIRes {
        return exchangeService.fromBrlToUsd(exchangeAPIReq.toExchange()).toRequestApiRes()
    }

}