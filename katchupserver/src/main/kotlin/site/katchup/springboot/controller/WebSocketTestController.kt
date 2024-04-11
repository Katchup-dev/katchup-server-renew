package site.katchup.springboot.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Controller
import site.katchup.springboot.dto.ChatMessage


@Controller
class WebSocketTestController(
    private val simpMessageSendingOperations: SimpMessageSendingOperations
) {
    @MessageMapping("/chat")
    fun handle(message: ChatMessage) {
        simpMessageSendingOperations.convertAndSend("/sub/channel" + message.channelId, message.data)
    }
}