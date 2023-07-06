package hello.servlet.basic.response

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import hello.servlet.basic.HelloData
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseJsonServlet", urlPatterns = ["/response-json"])
class ResponseJsonServlet : HttpServlet() {
    private val objectMapper = ObjectMapper()
        .registerKotlinModule()

    override fun service(request: HttpServletRequest, response: HttpServletResponse): Unit = with(response) {
        contentType = "application/json"

        HelloData(username = "kim", age = 20)
            .let(objectMapper::writeValueAsString)
            .let(writer::write)
    }

}
