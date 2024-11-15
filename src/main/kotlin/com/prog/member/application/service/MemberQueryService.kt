package com.prog.member.application.service

import com.prog.member.application.port.input.MemberQueryUseCase
import com.prog.member.application.port.output.MemberQueryPort
import com.prog.member.domain.model.aggregates.Member

class MemberQueryService(
    private val memberQueryPort: MemberQueryPort,
) : MemberQueryUseCase {

    // TODO 모든 반환값 받은것에 대해서 exception 처리 => service 계층에서 할 것

    override fun getMemberById(id: Long): Member {
        TODO()
        memberQueryPort.findById(id)
    }

    override fun getMemberByNickname(nickname: String): Member? {
        return memberQueryPort.search(nickname)
    }

    override fun getMemberByLoginId(loginId: String): Member? {
        return memberQueryPort.search(loginId)
    }

}