package com.example.training.trainingkotlin.api

import com.example.training.trainingkotlin.domain.api.RequestAPIReq
import com.example.training.trainingkotlin.domain.api.RequestAPIRes
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

interface ExchangeAPI {

    @PostMapping("/currency/real/dolar")
    fun apiConverterFromRealToDolar(@Valid @RequestBody exchangeAPIReq: RequestAPIReq): RequestAPIRes

}