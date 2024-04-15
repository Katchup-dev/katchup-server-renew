package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class NotFoundException(
    failMessage: FailMessage,
) : KatchupException(
    HttpStatus.NOT_FOUND,
    failMessage,
)
