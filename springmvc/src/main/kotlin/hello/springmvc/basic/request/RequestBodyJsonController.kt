package hello.springmvc.basic.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import hello.springmvc.basic.HelloData
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Controller
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.nio.charset.StandardCharsets

@Controller
class RequestBodyJsonController {

    private val log: Logger = LoggerFactory.getLogger(javaClass)
    private val objectMapper = ObjectMapper().registerKotlinModule()

    @PostMapping("/request-body-json-v1")
    fun requestBodyJsonV1(
        request: HttpServletRequest,
        response: HttpServletResponse,
    ): Unit = request
        .inputStream
        .let { StreamUtils.copyToString(it, StandardCharsets.UTF_8) }
        .also { log.info("messageBody={}", it) }
        .let { objectMapper.readValue(it, HelloData::class.java) }
        .let { log.info("username={}, age={}", it.username, it.age) }
        .let { response }
        .writer
        .write("ok")

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    fun requestBodyJsonV2(
        @RequestBody messageBody: String,
    ): String = messageBody
        .let { objectMapper.readValue(it, HelloData::class.java) }
        .let { log.info("username={}, age={}", it.username, it.age) }
        .let { "ok" }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    fun requestBodyJsonV3(
        @RequestBody helloData: HelloData,
    ): String = helloData
        .let { log.info("username={}, age={}", it.username, it.age) }
        .let { "ok" }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    fun requestBodyJsonV4(
        httpEntity: HttpEntity<HelloData>,
    ): String = httpEntity
        .body
        ?.let { log.info("username={}, age={}", it.username, it.age) }
        .let { "ok" }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    fun requestBodyJsonV4(
        @RequestBody data: HelloData,
    ): HelloData = data
        .also { log.info("username={}, age={}", it.username, it.age) }

}
