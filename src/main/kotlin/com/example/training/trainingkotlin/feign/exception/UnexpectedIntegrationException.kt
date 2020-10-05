package com.example.training.trainingkotlin.feign.exception

class UnexpectedIntegrationException(
    httpStatus: Int,
    moduleName: String,
    responseBody: String?,
    message: String? = null
) :
    BaseIntegrationException(
        httpStatus = httpStatus,
        moduleName = moduleName,
        message = message ?: defaultMessageError(moduleName),
        responseBody = responseBody
    )