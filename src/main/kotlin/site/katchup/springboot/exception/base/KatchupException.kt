package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus

open class KatchupException(
    httpStatus: HttpStatus,
    message: String,
) : RuntimeException(message)
