package com.example.training.trainingkotlin.service.impl

import com.example.training.trainingkotlin.domain.service.Exchange
import com.example.training.trainingkotlin.domain.repository.ExchangeLogEntity
import com.example.training.trainingkotlin.feign.ExchangeRateClient
import com.example.training.trainingkotlin.repository.ExchangeLogRepository
import com.example.training.trainingkotlin.service.ExchangeService
import org.apache.logging.log4j.LogManager
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class ExchangeServiceImpl(
    val exchangeRateClient: ExchangeRateClient,
    val exchangeLogRepository: ExchangeLogRepository
) : ExchangeService {

    protected val logger = LogManager.getLogger(this.javaClass)

    override fun fromBrlToUsd(exchange: Exchange): Exchange {

        logger.info("Sending partner request")

        val rateClientResponse = exchangeRateClient.getRate()

        logger.info("Calculating amount")
        val usdValue = exchange.amount.divide(rateClientResponse.rate.brl, 1, RoundingMode.FLOOR)

        logger.info("Saving log")
        saveLog(exchange.amount, usdValue)

        return Exchange(usdValue)

    }

    override fun saveLog(brlAmount: BigDecimal, usdAmount: BigDecimal) {
        val exchangeLogEntity = ExchangeLogEntity(
            realAmount = brlAmount,
            dolarAmount = usdAmount
        )

        exchangeLogRepository.save(exchangeLogEntity)
    }
}