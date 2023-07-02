package hello.servlet.web.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "memberFormServlet", urlPatterns = ["/servlet/members/new-form"])
class MemberFormServlet: HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
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
                <form action="/servlet/members/save" method="post">
                    username: <input type="text" name="username" />
                    age:      <input type="text" name="age" />
                    <button type="submit">전송</button>
                </form>
                </body>
                </html>
            """.trimIndent())
        }
    }
}
