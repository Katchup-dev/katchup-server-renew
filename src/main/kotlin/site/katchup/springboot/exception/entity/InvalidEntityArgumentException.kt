package site.katchup.springboot.exception.entity

import site.katchup.springboot.exception.base.BadRequestException
import site.katchup.springboot.global.message.FailMessage

class InvalidEntityArgumentException(failMessage: FailMessage) : BadRequestException(failMessage)
