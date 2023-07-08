package hello.springmvc.basic.request

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
import java.io.InputStream
import java.io.Writer
import java.nio.charset.StandardCharsets

@Controller
class RequestBodyStringController {

    private val log: Logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/request-body-string-v1")
    fun requestBodyString(
        request: HttpServletRequest,
        response: HttpServletResponse,
    ): Unit = request
        .inputStream
        .let { StreamUtils.copyToString(it, StandardCharsets.UTF_8) }
        .let { log.info("messageBody={}", it) }
        .let { response }
        .writer
        .write("ok")

    @PostMapping("/request-body-string-v2")
    fun requestBodyStringV2(
        inputStream: InputStream,
        responseWriter: Writer,
    ): Unit = inputStream
        .let { StreamUtils.copyToString(it, StandardCharsets.UTF_8) }
        .let { log.info("messageBody={}", it) }
        .let { responseWriter }
        .write("ok")

    @PostMapping("/request-body-string-v3")
    fun requestBodyStringV3(
        httpEntity: HttpEntity<String>,
    ): HttpEntity<String> = httpEntity
        .body
        .let { log.info("messageBody={}", it) }
        .let { HttpEntity("ok") }

    @ResponseBody
    @PostMapping("/request-body-string-v4")
    fun requestBodyStringV4(
        @RequestBody messageBody: String,
    ): String = "ok"
        .also { log.info("messageBody={}", messageBody) }

}
