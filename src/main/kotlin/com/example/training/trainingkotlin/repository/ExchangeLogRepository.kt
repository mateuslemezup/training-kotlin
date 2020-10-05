package com.example.training.trainingkotlin.repository

import com.example.training.trainingkotlin.domain.repository.ExchangeLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExchangeLogRepository: JpaRepository<ExchangeLogEntity, UUID>{

}