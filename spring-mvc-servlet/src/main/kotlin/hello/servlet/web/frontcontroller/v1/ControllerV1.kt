package hello.servlet.web.frontcontroller.v1

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

interface ControllerV1 {
    fun process(request: HttpServletRequest, response: HttpServletResponse)
}
