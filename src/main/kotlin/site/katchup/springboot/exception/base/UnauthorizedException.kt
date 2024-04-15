package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus
import site.katchup.springboot.global.message.FailMessage

open class UnauthorizedException(
    failMessage: FailMessage,
) : KatchupException(
    HttpStatus.UNAUTHORIZED,
    failMessage,
)
