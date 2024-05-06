package site.katchup.springboot.dto.task.response

import com.fasterxml.jackson.annotation.JsonFormat
import site.katchup.springboot.entity.Task
import java.time.LocalDateTime

data class TaskResponse(
    val id: Long,
    val title: String,
    val content: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    val createdAt: LocalDateTime,
) {

    companion object {

        fun of(
            task: Task,
        ): TaskResponse {
            return TaskResponse(
                id = task.id!!,
                title = task.title,
                content = task.content,
                createdAt = task.createdAt,
            )
        }
    }
}
