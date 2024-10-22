package site.katchup.springboot.service.task

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import site.katchup.springboot.dto.task.request.TaskRequest
import site.katchup.springboot.dto.task.request.TaskUpdateRequest
import site.katchup.springboot.dto.task.response.TaskResponse
import site.katchup.springboot.entity.Task
import site.katchup.springboot.entity.TaskStatus
import site.katchup.springboot.repository.TaskRepository
import site.katchup.springboot.service.memberworkspace.MemberWorkSpaceFinder

@Service
@Transactional(readOnly = true)
class TaskService(
    private val taskRepository: TaskRepository,
    private val memberWorkSpaceFinder: MemberWorkSpaceFinder,
    private val taskFinder: TaskFinder,
) {

    @Transactional
    fun addTask(memberId: Long, request: TaskRequest) {
        val memberWorkSpace = memberWorkSpaceFinder.findMemberWorkSpaceOrThrow(memberId, request.workSpaceId)
        val task = Task(
            title = request.title,
            content = request.content,
            status = TaskStatus.IN_PROGRESS,
            memberWorkSpaceId = memberWorkSpace.id!!,
        )
        taskRepository.save(task)
    }

    @Transactional
    fun updateTask(memberId: Long, taskId: Long, request: TaskUpdateRequest) {
        val task = taskFinder.findTaskOrThrow(taskId)
        task.title = request.title
        task.content = request.content
    }

    fun getTask(memberId: Long, taskId: Long): TaskResponse {
        val task = taskFinder.findTaskOrThrow(taskId)
        return TaskResponse.of(task)
    }
}
