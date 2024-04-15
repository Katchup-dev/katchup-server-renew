package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class NotFoundException(
    message: FailMessage,
) : KatchupException(
    HttpStatus.NOT_FOUND,
    message.value,
)
