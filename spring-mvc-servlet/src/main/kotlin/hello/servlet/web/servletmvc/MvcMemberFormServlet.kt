package hello.servlet.web.servletmvc

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = ["/servlet-mvc/members/new-form"])
class MvcMemberFormServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) =
        forward("/WEB-INF/views/new-form.jsp", request, response)
}
