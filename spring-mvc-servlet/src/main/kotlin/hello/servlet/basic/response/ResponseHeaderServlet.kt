package hello.servlet.basic.response

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "responseHeaderServlet", urlPatterns = ["/response-header"])
class ResponseHeaderServlet : HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse): Unit = with(response) {
        status = HttpServletResponse.SC_OK

        content()

        setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        setHeader("Pragma", "no-cache")
        setHeader("my-header", "hello")

        cookie()
        redirect()

        writer.write("안녕하세요")
    }

    private fun HttpServletResponse.content() {
        contentType = "text/plain"
        characterEncoding = "utf-8"
    }

    private fun HttpServletResponse.cookie(): Unit =
        Cookie("myCookie", "good")
            .apply { maxAge = 600 }
            .let(this::addCookie)

    private fun HttpServletResponse.redirect() {
//        status = HttpServletResponse.SC_FOUND
//        setHeader("Location", "/basic/hello-form.html")
        sendRedirect("/basic/hello-form.html")
    }

}
