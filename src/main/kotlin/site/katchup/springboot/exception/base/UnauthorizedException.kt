package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class UnauthorizedException(
    message: FailMessage,
) : KatchupException(
    HttpStatus.UNAUTHORIZED,
    message.value,
)
