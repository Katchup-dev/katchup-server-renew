package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class KatchupException(
    val httpStatus: HttpStatus,
    val failMessage: FailMessage,
) : RuntimeException(failMessage.value)
