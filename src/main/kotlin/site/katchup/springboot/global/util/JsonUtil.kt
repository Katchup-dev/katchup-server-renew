package site.katchup.springboot.global.util

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class JsonUtil {

    companion object {
        fun getJSONStringBody(requestObject: Any): String {
            return jacksonObjectMapper().apply {
                factory.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true)
            }.writeValueAsString(requestObject)
        }
    }
}
