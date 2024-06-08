package site.katchup.springboot.external.fcm

import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.stereotype.Component
import site.katchup.springboot.exception.base.InternalServerException
import site.katchup.springboot.global.message.FailMessage

@Component
class FcmSender(
    private val firebaseMessaging: FirebaseMessaging,
) {
    fun sendMessage(fcmRequest: FcmRequest) {
        try {
            val message = Message.builder()
                .setToken(fcmRequest.targetToken)
                .setNotification(
                    Notification.builder()
                        .setTitle(fcmRequest.title)
                        .setBody(fcmRequest.content)
                        .build(),
                )
                .build()
            firebaseMessaging.sendAsync(message)
        } catch (_: Exception) {
            throw InternalServerException(FailMessage.FCM_SEND_ERROR)
        }
    }
}
