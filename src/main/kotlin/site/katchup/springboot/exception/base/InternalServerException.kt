package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class InternalServerException(
    message: FailMessage,
) : KatchupException(
    HttpStatus.INTERNAL_SERVER_ERROR,
    message.value,
)
