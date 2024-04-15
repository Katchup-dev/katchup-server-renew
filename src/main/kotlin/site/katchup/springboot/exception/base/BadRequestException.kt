package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class BadRequestException(
    failMessage: FailMessage,
) : KatchupException(
    HttpStatus.BAD_REQUEST,
    failMessage,
)
