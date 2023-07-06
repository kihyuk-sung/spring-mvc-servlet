package hello.servlet.web.servlet

import hello.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "memberListServlet", urlPatterns = ["/servlet/members"])
class MemberListServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val memberList = MemberRepository.findAll()

        with(response) {
            contentType = "text/html"
            characterEncoding = "utf-8"

            writer.write("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                <a href="/index.html">메인</a>
                <table>
                    <thead>
                    <th>id</th>
                    <th>username</th>
                    <th>age</th>
                    </thead>
                    <tbody>
                    ${
                memberList.joinToString("\n") {
                    """
                    <tr>
                    <td>${it.id}</td>
                    <td>${it.username}</td>
                    <td>${it.age}</td>
                    </tr> 
                    """
                }
            }
                    </tbody>
                </table>
                </body>
                </html>
            """.trimIndent())
        }
    }
}
