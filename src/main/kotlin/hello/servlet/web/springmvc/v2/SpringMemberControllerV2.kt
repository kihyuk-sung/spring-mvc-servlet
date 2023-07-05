package hello.servlet.web.springmvc.v2

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/springmvc/v2/members")
class SpringMemberControllerV2 {
    @RequestMapping("/new-form")
    fun newForm(): ModelAndView = ModelAndView("new-form")

    @RequestMapping
    fun members(): ModelAndView =
        ModelAndView("members", mapOf("members" to MemberRepository.findAll()))

    @RequestMapping("/save")
    fun save (request: HttpServletRequest): ModelAndView =
        Member(
            id = IdGenerator.next(),
            username = request.getParameter("username") ?: "defaultName",
            age = request.getParameter("age")?.toIntOrNull() ?: 10,
        )
            .let(MemberRepository::save)
            .let { mapOf("member" to it) }
            .let { ModelAndView("save-result", it) }
}
