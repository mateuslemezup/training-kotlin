package com.example.training.trainingkotlin.domain.repository

import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "exchange_log")
data class ExchangeLogEntity(
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true, length = 16)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "typing_date", nullable = false)
    val typingDate: LocalDateTime = now(),

    @Column(name = "real_amount", nullable = false)
    val realAmount: BigDecimal = BigDecimal.ZERO,

    @Column(name = "dolar_amount", nullable = false)
    val dolarAmount: BigDecimal = BigDecimal.ZERO
)