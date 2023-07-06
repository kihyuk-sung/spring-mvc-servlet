package hello.servlet.web.servlet

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "memberSaveServlet", urlPatterns = ["/servlet/members/save"])
class MemberSaveServlet: HttpServlet() {
    private var sequence: Long = 0L

    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        println("MemberSaveServlet.service")
        val username: String = request.getParameter("username") ?: "default name"
        val age: Int = request.getParameter("age")?.toIntOrNull() ?: 10
        val member = Member(id = ++sequence, username = username, age = age)

        MemberRepository.save(member)

        with(response) {
            contentType = "text/html"
            characterEncoding = "utf-8"

            writer.write("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                </head>
                <body>
                성공
                <ul>
                    <li>id=${member.id}</li>
                    <li>username=${member.username}</li>
                    <li>age=${member.age}</li>
                </ul>
                <a href="/index.html">메인</a>
                </body>
                </html>
            """.trimIndent())
        }
    }
}
