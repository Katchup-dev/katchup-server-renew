package site.katchup.springboot.service.task

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import site.katchup.springboot.entity.Task
import site.katchup.springboot.exception.entity.EntityNotFoundException
import site.katchup.springboot.global.message.FailMessage
import site.katchup.springboot.repository.TaskRepository
import java.util.*

@Component
class TaskFinder(
    private val taskRepository: TaskRepository,
) {
    fun findTaskOrThrow(taskId: Long): Task {
        return taskRepository.findByIdOrNull(taskId) ?: throw EntityNotFoundException(FailMessage.TASK_NOT_FOUND)
    }
}
