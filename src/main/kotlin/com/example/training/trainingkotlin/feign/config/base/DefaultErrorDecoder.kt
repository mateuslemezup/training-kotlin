package com.example.training.trainingkotlin.feign.config.base

import com.example.training.trainingkotlin.feign.exception.UnexpectedIntegrationException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder
import org.apache.logging.log4j.LogManager
import java.io.IOException
import java.io.InputStream

fun InputStream?.asString(): String? {
    val body = this?.readBytes()?.let { String(it).trim() }.orEmpty()
    return if (body == "{}") null else body
}

fun ByteArray?.asString(): String? {
    val body = this?.let { String(it).trim() }.orEmpty()
    return if (body == "{}") null else body
}

class DefaultErrorDecoder(private val module: String) : ErrorDecoder {

    protected val logger = LogManager.getLogger(this.javaClass)

    override fun decode(methodKey: String, response: Response): Exception {
        logger.error(
            """
            |[ERROR] Status Code: ${response.status()}
            |[ERROR] Headers: ${response.headers()}
            |[ERROR] Payload: ${response.request().body().asString()}
        """.trimMargin()
        )


        if (response.status() in 400..499) {
            return FeignException.errorStatus(methodKey, response)
        }

        return UnexpectedIntegrationException(
            httpStatus = response.status(),
            moduleName = module,
            responseBody = getBody(response)
        )
    }

    protected fun getBody(response: Response): String? {
        try {
            return response.body()?.asInputStream()?.asString()?.takeIf { it.isNotEmpty() }
        } catch (e: IOException) {
            return "Falha ao serializar payload: ${e.message}"
        }
    }
}