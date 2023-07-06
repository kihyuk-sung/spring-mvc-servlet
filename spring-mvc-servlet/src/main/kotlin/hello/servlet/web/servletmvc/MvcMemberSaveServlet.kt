package hello.servlet.web.servletmvc

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = ["/servlet-mvc/members/save"])
class MvcMemberSaveServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) =
        forward("/WEB-INF/views/save-result.jsp", request, response) {
            val id = IdGenerator.next()
            val username = request.getParameter("username") ?: "defaultName"
            val age = request.getParameter("age").toIntOrNull() ?: 10
            Member(
                id = id,
                username = username,
                age = age,
            )
                .also(MemberRepository::save)
                .let { request.setAttribute("member", it) }
        }


}
