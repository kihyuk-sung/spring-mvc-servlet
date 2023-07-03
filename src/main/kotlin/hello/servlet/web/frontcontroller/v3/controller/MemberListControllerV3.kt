package hello.servlet.web.frontcontroller.v3.controller

import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3

class MemberListControllerV3: ControllerV3 {
    override fun process(paramMap: Map<String, String>): ModelView {
        val members = MemberRepository.findAll()

        return ModelView("members", mapOf("members" to members))
    }
}
