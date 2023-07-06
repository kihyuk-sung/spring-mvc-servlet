package hello.servlet.basic.request

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets

@WebServlet(name = "requestBodyStringServlet", urlPatterns = ["/request-body-string"])
class RequestBodyStringServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        request.inputStream
            .let { StreamUtils.copyToString(it, StandardCharsets.UTF_8) }
            .let { println("messageBody = $it") }

        response.writer.write("ok")
    }
}
