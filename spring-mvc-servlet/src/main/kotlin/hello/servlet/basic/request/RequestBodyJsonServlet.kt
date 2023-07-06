package hello.servlet.basic.request

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import hello.servlet.basic.HelloData
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = ["/request-body-json"])
class RequestBodyJsonServlet: HttpServlet() {

    private val objectMapper: ObjectMapper = ObjectMapper()
        .registerKotlinModule()

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        request.inputStream
            .let { StreamUtils.copyToString(it, StandardCharsets.UTF_8) }
            .also { println("messageBody = $it") }
            .let { objectMapper.readValue(it, HelloData::class.java) }
            .apply {
                println("helloData.username = $username")
                println("helloData.age = $age")
            }

        response.writer.write("ok")
    }
}
