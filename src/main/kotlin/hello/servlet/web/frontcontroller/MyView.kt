package hello.servlet.web.frontcontroller

import hello.servlet.web.servletmvc.forward
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class MyView(
    private val viewPath: String,
) {
    fun render(request: HttpServletRequest, response: HttpServletResponse) {
        forward(viewPath, request, response)
    }
}
