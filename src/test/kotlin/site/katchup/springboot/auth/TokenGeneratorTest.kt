package site.katchup.springboot.auth

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class TokenGeneratorTest(
    @Autowired
    private val tokenGenerator: TokenGenerator,
    @Autowired
    private val tokenValidator: TokenValidator,
) : FunSpec({

    test("사용자 ID로 Token 생성 및 Token 생성 후에 Token 검증이 정상적으로 이루어져야 한다.") {
        val memberId = 1L
        val token = tokenGenerator.generate(memberId, 1)
        val decodedMemberId = tokenValidator.validate("Bearer $token")
        decodedMemberId shouldBe memberId
    }
},)
