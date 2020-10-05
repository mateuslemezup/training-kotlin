package com.example.training.trainingkotlin.feign.config

import com.example.training.trainingkotlin.feign.ExchangeRateClient
import com.example.training.trainingkotlin.feign.config.base.DefaultErrorDecoder
import com.example.training.trainingkotlin.feign.config.base.FeignBaseConfig
import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

const val MODULE_NAME = "TRAINING-KOTLIN"

@Configuration
class ExchangeRateClientConfig(@Value("\${partner.host}") private val partnerHost: String) : FeignBaseConfig() {

    @Bean
    fun exchangeRateClient(): ExchangeRateClient {
        return createBuilder()
            .target(ExchangeRateClient::class.java, partnerHost)
    }

    override fun interceptor(): RequestInterceptor {
        return RequestInterceptor {
            it.header("x-teste", "teste")
        }
    }

    override fun errorDecoder(): ErrorDecoder {
        return DefaultErrorDecoder(MODULE_NAME)
    }
}