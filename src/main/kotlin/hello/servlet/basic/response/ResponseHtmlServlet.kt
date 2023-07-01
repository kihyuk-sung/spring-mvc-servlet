package hello.servlet.basic.response

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.InputStream

@WebServlet(name = "responseHtmlServlet", urlPatterns = ["/response-html"])
class ResponseHtmlServlet : HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse): Unit = with(response) {
        contentType = "text/html"
        characterEncoding = "utf-8"
        writer.println("<html>")
        writer.println("<body>")
        writer.println("  <div>안녕?</div>")
        writer.println("</body>")
        writer.println("</html>")
    }

}
