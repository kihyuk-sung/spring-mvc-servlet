package hello.servlet.web.servletmvc

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

inline fun forward(
    viewPath: String,
    request: HttpServletRequest,
    response: HttpServletResponse,
    logic: () -> Unit = {},
) {
    logic()
    request.getRequestDispatcher(viewPath)
        .forward(request, response)
}
