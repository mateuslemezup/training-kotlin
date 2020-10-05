package com.example.training.trainingkotlin.domain.feign

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExchangeClientResponse (
    @JsonProperty("rates")
    var rate: Rate
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rate(
    @JsonProperty("USD")
    var usd: BigDecimal = BigDecimal.ZERO,
    @JsonProperty("BRL")
    var brl: BigDecimal = BigDecimal.ZERO
)