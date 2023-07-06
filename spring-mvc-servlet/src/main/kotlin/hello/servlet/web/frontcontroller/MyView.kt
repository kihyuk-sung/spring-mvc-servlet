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

    fun render(model: Map<String, Any>, request: HttpServletRequest, response: HttpServletResponse) {
        modelToRequestAttribute(model, request)
        forward(viewPath, request, response)
    }

    private fun modelToRequestAttribute(
        model: Map<String, Any>,
        request: HttpServletRequest,
    ) {
        model.forEach { (k, v) -> request.setAttribute(k, v) }
    }
}
