package site.katchup.springboot.auth

import com.auth0.jwt.JWT.require
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import site.katchup.springboot.exception.auth.InvalidTokenException
import site.katchup.springboot.global.message.FailMessage

@Component
class TokenValidator(
    @Value("\${katchup.jwt.secret-key}") private val secretKey: String,
) {

    companion object {
        private const val MEMBER_ID = "memberId"
    }

    fun validate(token: String): Long {
        try {
            val algorithm = Algorithm.HMAC256(secretKey)
            val verifier: JWTVerifier = require(algorithm)
                .withIssuer("katchup")
                .withClaimPresence(MEMBER_ID)
                .build()
            val decodedJWT = verifier.verify(parse(token))
            return decodedJWT.getClaim(MEMBER_ID).asLong()
        } catch (e: JWTVerificationException) {
            throw InvalidTokenException(FailMessage.INVALID_TOKEN)
        }
    }

    private fun parse(token: String): String {
        if (!token.startsWith("Bearer ")) {
            throw InvalidTokenException(FailMessage.INVALID_TOKEN)
        }
        return token.substring(7)
    }
}
