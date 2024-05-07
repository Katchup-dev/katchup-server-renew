package site.katchup.springboot.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import site.katchup.springboot.auth.Auth
import site.katchup.springboot.dto.task.request.TaskRequest
import site.katchup.springboot.dto.task.request.TaskUpdateRequest
import site.katchup.springboot.dto.task.response.TaskResponse
import site.katchup.springboot.global.message.SuccessMessage
import site.katchup.springboot.global.response.BaseResponse
import site.katchup.springboot.service.task.TaskService

@ApiControllerV1
class TaskController(
    private val taskService: TaskService,
) {

    @PostMapping("/tasks")
    fun addTask(
        @Auth memberId: Long,
        @RequestBody request: TaskRequest,
    ): ResponseEntity<BaseResponse<Unit>> {
        taskService.addTask(memberId, request)
        return BaseResponse.created(SuccessMessage.SUCCESS_ADD_TASK)
    }

    @PatchMapping("/tasks/{taskId}")
    fun updateTask(
        @Auth memberId: Long,
        @RequestBody request: TaskUpdateRequest,
        @PathVariable taskId: Long,
    ): ResponseEntity<BaseResponse<Unit>> {
        taskService.updateTask(memberId, taskId, request)
        return BaseResponse.ok(SuccessMessage.SUCCESS_UPDATE_TASK)
    }

    @GetMapping("/tasks/{taskId}")
    fun getTask(
        @Auth memberId: Long,
        @PathVariable taskId: Long,
    ): ResponseEntity<BaseResponse<TaskResponse>> {
        val response = taskService.getTask(memberId, taskId)
        return BaseResponse.ok(SuccessMessage.SUCCESS_GET_TASK, response)
    }
}
