package site.katchup.springboot.dto.task.request

import site.katchup.springboot.exception.base.BadRequestException
import site.katchup.springboot.global.message.FailMessage

data class TaskUpdateRequest(
    val title: String,
    val content: String,
) {
    init {
        validate()
    }

    private fun validate() {
        if (title.isBlank() && title.length > 60) {
            throw BadRequestException(FailMessage.INVALID_PARAMETER)
        }
        if (content.isBlank() && content.length > 600) {
            throw BadRequestException(FailMessage.INVALID_PARAMETER)
        }
    }
}
