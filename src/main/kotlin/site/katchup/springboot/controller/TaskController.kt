package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import site.katchup.springboot.dto.task.request.TaskRequest
import site.katchup.springboot.global.message.SuccessMessage
import site.katchup.springboot.global.response.BaseResponse
import site.katchup.springboot.service.task.TaskService

@ApiControllerV1
class TaskController(
    private val taskService: TaskService,
) {

    @PostMapping("/tasks")
    fun addTask(memberId: Long, @RequestBody request: TaskRequest): ResponseEntity<BaseResponse<Unit>> {
        taskService.addTask(memberId, request)
        return BaseResponse.ok(SuccessMessage.SUCCESS_ADD_TASK)
    }
}
