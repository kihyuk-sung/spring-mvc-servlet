package hello.servlet.web.servletmvc

import hello.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberListServlet", urlPatterns = ["/servlet-mvc/members"])
class MvcMemberListServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) =
        forward("/WEB-INF/views/members.jsp", request, response) {
            request.setAttribute("members", MemberRepository.findAll())
        }
}
