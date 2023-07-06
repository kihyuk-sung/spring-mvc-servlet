package hello.servlet.web.springmvc.v3

import hello.servlet.domain.member.IdGenerator
import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/springmvc/v3/members")
class SpringMemberControllerV3 {
    @GetMapping("/new-form")
    fun newForm(): String = "new-form"

    @GetMapping
    fun members(model: Model): String = model
        .addAttribute("members", MemberRepository.findAll())
        .let { "members" }

    @PostMapping("/save")
    fun save(
        @RequestParam("username") username: String,
        @RequestParam("age") age: Int,
        model: Model,
    ): String =
        Member(
            id = IdGenerator.next(),
            username = username,
            age = age,
        )
            .let(MemberRepository::save)
            .let { model.addAttribute("member", it) }
            .let { "save-result" }
}
