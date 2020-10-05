package com.example.training.trainingkotlin.feign.config.base

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import feign.Logger
import feign.RequestInterceptor
import feign.Retryer
import feign.codec.Decoder
import feign.codec.Encoder
import feign.codec.ErrorDecoder
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.slf4j.Slf4jLogger
import org.springframework.cloud.openfeign.support.SpringMvcContract

abstract class FeignBaseConfig {

    abstract fun interceptor(): RequestInterceptor

    abstract fun errorDecoder(): ErrorDecoder

    fun createBuilder(): Feign.Builder {
        return Feign.builder()
            .encoder(createEncoder())
            .decoder(createDecoder())
            .requestInterceptor(interceptor())
            .logger(Slf4jLogger())
            .logLevel(Logger.Level.FULL)
            .errorDecoder(this.errorDecoder())
            .retryer(Retryer.NEVER_RETRY)
            .contract(SpringMvcContract())
    }

    private fun createEncoder(): Encoder = JacksonEncoder(ObjectMapper())

    private fun createDecoder(): Decoder = JacksonDecoder(ObjectMapper())
}