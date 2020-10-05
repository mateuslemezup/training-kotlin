package com.example.training.trainingkotlin

import com.example.training.trainingkotlin.domain.service.Exchange
import com.example.training.trainingkotlin.feign.ExchangeRateAutoClient
import com.example.training.trainingkotlin.feign.ExchangeRateClient
import com.example.training.trainingkotlin.repository.ExchangeLogRepository
import com.example.training.trainingkotlin.service.impl.ExchangeServiceImpl
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class TrainingKotlinApplication (val exchangeLogRepository: ExchangeLogRepository,
					   val exchangeRateAutoClient: ExchangeRateAutoClient,
					   val exchangeRateClient: ExchangeRateClient,
					   val exchangeServiceImpl: ExchangeServiceImpl
					   ) : ApplicationRunner{
	override fun run(args: ApplicationArguments?) {
		val exchangeLogEntities = exchangeLogRepository.findAll()

		exchangeLogEntities.forEach{
			println(it)
		}

		val autoRate = exchangeRateAutoClient.getRate()

		println(autoRate)

		val rate = exchangeRateClient.getRate()

		println(rate)

		val usdValue = exchangeServiceImpl.fromBrlToUsd(Exchange(amount = 56.40.toBigDecimal()))

		println(usdValue)

	}

}

fun main(args: Array<String>) {
	runApplication<TrainingKotlinApplication>(*args)
}
