package hello.servlet.web.springmvc.v1

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SpringMemberSaveControllerV1 {

    @RequestMapping("/springmvc/v1/members/save")
    fun process(request: HttpServletRequest): ModelAndView =
        Member(
            id = IdGenerator.next(),
            username = request.getParameter("username") ?: "defaultName",
            age = request.getParameter("age")?.toIntOrNull() ?: 10,
        )
            .let(MemberRepository::save)
            .let { mapOf("member" to it) }
            .let { ModelAndView("save-result", it) }

}
