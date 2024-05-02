package site.katchup.springboot.exception.entity

import site.katchup.springboot.exception.base.NotFoundException
import site.katchup.springboot.global.message.FailMessage

class EntityNotFoundException(failMessage: FailMessage) : NotFoundException(failMessage)
