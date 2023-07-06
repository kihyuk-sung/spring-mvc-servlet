package hello.servlet.web.springmvc.v1

import hello.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SpringMemberListControllerV1  {

    @RequestMapping("/springmvc/v1/members")
    fun process(): ModelAndView =
        ModelAndView("members", mapOf("members" to MemberRepository.findAll()))
}
