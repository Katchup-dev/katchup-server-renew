package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class ForbiddenException(
    message: FailMessage,
) : KatchupException(
    HttpStatus.FORBIDDEN,
    message.value,
)
