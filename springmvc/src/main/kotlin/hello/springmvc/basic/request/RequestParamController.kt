package hello.springmvc.basic.request

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class RequestParamController {
    private final val log: Logger = LoggerFactory.getLogger(javaClass)

    @RequestMapping("/request-param-v1")
    fun requestParamV1(request: HttpServletRequest, response: HttpServletResponse): Unit = response
        .writer
        .write("ok")
        .also {
            log.info(
                "username={}, age={}",
                request.getParameter("username") ?: "default",
                request.getParameter("age").toIntOrNull() ?: 10,
            )
        }
}
