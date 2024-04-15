package site.katchup.springboot.repository

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles

@DataJpaTest
@ActiveProfiles("test")
@ComponentScan("site.katchup.springboot.repository")
annotation class RepositoryTest()
