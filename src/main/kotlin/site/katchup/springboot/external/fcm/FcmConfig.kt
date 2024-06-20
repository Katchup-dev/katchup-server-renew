package site.katchup.springboot.external.fcm

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import javax.annotation.PostConstruct

@Configuration
class FcmConfig() {

    lateinit var firebaseMessaging: FirebaseMessaging

    @PostConstruct
    fun init() {
        val privateKey = ClassPathResource("katchup_fcm.json").inputStream
        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(privateKey))
            .build()
        val app = FirebaseApp.initializeApp(options)
        this.firebaseMessaging = FirebaseMessaging.getInstance(app)
    }

    @Bean
    fun firebaseMessaging(): FirebaseMessaging {
        return firebaseMessaging
    }
}
