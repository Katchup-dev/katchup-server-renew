package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus

open class ForbiddenException(
    message: String,
) : KatchupException(
    HttpStatus.FORBIDDEN,
    message,
)
