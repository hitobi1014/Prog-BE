package com.prog.member.application.service

import com.prog.member.application.port.input.MemberQueryUseCase
import com.prog.member.application.port.input.dto.response.MemberResponse
import com.prog.member.application.port.output.MemberQueryPort
import com.prog.member.domain.mapper.toDto
import com.prog.member.domain.model.aggregates.Member

class MemberQueryService(
    private val memberQueryPort: MemberQueryPort,
) : MemberQueryUseCase {

    // TODO 모든 반환값 받은것에 대해서 exception 처리 => service 계층에서 할 것 , exception Member 전용으로 변경

    override fun getMemberById(id: Long): MemberResponse {
        return toMemberResponse(memberQueryPort.findById(id))
    }

    override fun getMemberByNickname(nickname: String): MemberResponse {
        return toMemberResponse(memberQueryPort.search(nickname))
    }

    override fun getMemberByLoginId(loginId: String): MemberResponse {
        return toMemberResponse(memberQueryPort.search(loginId))
    }

    private fun toMemberResponse(member: Member?): MemberResponse {
        member ?: throw NoSuchElementException("Member not found")
        return member.toDto()
    }

}