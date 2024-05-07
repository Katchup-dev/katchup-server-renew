package site.katchup.springboot.auth

import jakarta.servlet.http.HttpServletRequest
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import site.katchup.springboot.exception.auth.InvalidTokenException
import site.katchup.springboot.global.message.FailMessage
import site.katchup.springboot.repository.MemberRepository

@Component
class AuthorizationArgumentResolver(
    private val tokenValidator: TokenValidator,
    private val memberRepository: MemberRepository,
) : HandlerMethodArgumentResolver {

    companion object {
        private const val AUTHORIZATION = "Authorization"
    }
    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.hasParameterAnnotation(Auth::class.java)
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?,
    ): Any? {
        val request = webRequest.getNativeRequest(HttpServletRequest::class.java)
        val jwt = request?.let { extractToken(it) } ?: throw InvalidTokenException(FailMessage.INVALID_TOKEN)
        val memberId = tokenValidator.validate(jwt)
        if (!memberRepository.existsById(memberId)) {
            throw InvalidTokenException(FailMessage.INVALID_TOKEN)
        }
        return memberId
    }

    private fun extractToken(request: HttpServletRequest): String {
        val token = request.getHeader(AUTHORIZATION)
        if (token == null || !token.startsWith("Bearer ")) {
            throw InvalidTokenException(FailMessage.INVALID_TOKEN)
        }
        return token.substring(7)
    }
}
