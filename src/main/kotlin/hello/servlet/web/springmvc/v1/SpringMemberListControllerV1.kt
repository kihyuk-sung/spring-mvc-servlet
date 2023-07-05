package hello.servlet.web.springmvc.v1

import hello.servlet.domain.member.MemberRepository
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SpringMemberListControllerV1  {

    @RequestMapping("/springmvc/v1/members")
    fun process(): ModelAndView =
        ModelAndView("members", mapOf("members" to MemberRepository.findAll()))
}
