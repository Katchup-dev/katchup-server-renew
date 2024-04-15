package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus

class UnauthorizedException(
    message: String,
) : KatchupException(
    HttpStatus.UNAUTHORIZED,
    message,
)
