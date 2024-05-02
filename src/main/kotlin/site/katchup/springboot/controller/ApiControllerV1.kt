package site.katchup.springboot.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.annotation.AnnotationTarget
import kotlin.annotation.Retention

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@RestController
@RequestMapping("/api/v1")
annotation class ApiControllerV1()
