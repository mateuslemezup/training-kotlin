package com.example.training.trainingkotlin.feign.exception

abstract class BaseIntegrationException(
    val httpStatus: Int? = null,
    open val code: String? = null,
    open val moduleName: String,
    override var message: String = defaultMessageError(moduleName),
    val responseBody: String? = null
) : RuntimeException(message) {
    companion object {
        fun defaultMessageError(module: String) = "$module Integration Error"
    }
}