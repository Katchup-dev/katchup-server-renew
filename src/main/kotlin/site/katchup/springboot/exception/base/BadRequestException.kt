package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus

open class BadRequestException(
    message: String,
) : KatchupException(
    HttpStatus.BAD_REQUEST,
    message,
)
