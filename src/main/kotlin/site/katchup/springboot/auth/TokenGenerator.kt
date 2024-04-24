package site.katchup.springboot.auth

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import site.katchup.springboot.exception.base.InternalServerException
import site.katchup.springboot.global.message.FailMessage
import java.time.LocalDateTime
import java.time.ZoneOffset.UTC
import java.util.*

@Component
class TokenGenerator(
    @Value("\${katchup.jwt.secret-key}") private val secretKey: String,
) {
    private val algorithm: Algorithm = Algorithm.HMAC256(secretKey)

    companion object {
        private const val MEMBER_ID = "memberId"
    }
    fun generate(memberId: Long, hours: Long): String {
        try {
            val expiresAt = Date.from(LocalDateTime.now().plusHours(hours).toInstant(UTC))
            return JWT.create()
                .withIssuer("katchup")
                .withClaim(MEMBER_ID, memberId)
                .withExpiresAt(expiresAt)
                .sign(algorithm)
        } catch (e: JWTCreationException) {
            throw InternalServerException(FailMessage.INTERNAL_SERVER_ERROR)
        }
    }
}
