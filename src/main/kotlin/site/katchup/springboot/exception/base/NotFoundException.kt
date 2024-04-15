package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus

open class NotFoundException(
    message: String,
) : KatchupException(
    HttpStatus.NOT_FOUND,
    message,
)
