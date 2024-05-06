package site.katchup.springboot.dto.task.request

data class TaskRequest(
    val title: String,
    val content: String,
    val workSpaceId: Long,
)
