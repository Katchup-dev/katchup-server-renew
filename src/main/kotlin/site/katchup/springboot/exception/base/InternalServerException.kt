package site.katchup.springboot.exception.base

import org.springframework.http.HttpStatus

class InternalServerException(
    message: String,
) : KatchupException(
    HttpStatus.INTERNAL_SERVER_ERROR,
    message,
)
