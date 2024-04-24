package site.katchup.springboot.exception.auth

import site.katchup.springboot.exception.base.UnauthorizedException
import site.katchup.springboot.global.message.FailMessage

class InvalidTokenException(failMessage: FailMessage) : UnauthorizedException(failMessage)
