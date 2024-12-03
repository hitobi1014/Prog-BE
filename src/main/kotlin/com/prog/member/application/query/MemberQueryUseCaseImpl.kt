package com.prog.member.application.query

import com.prog.member.domain.aggregates.Member
import com.prog.member.dto.request.MemberSearchConditionRequest
import com.prog.member.infrastructure.mapper.toDomain
import com.prog.member.infrastructure.repository.query.MemberQueryRepository
import org.springframework.stereotype.Service

@Service
class MemberQueryUseCaseImpl(
    private val memberQueryRepository: MemberQueryRepository,
) : MemberQueryUseCase {

    override fun getMemberById(id: Long): Member {
        val findMember = memberQueryRepository.findById(id)
        TODO("Not yet implemented")
    }

    override fun searchByCondition(searchMemberCondition: MemberSearchConditionRequest): Member? {
        // #1. 회원 검색
        val searchedMember = memberQueryRepository.search(
            nickname = searchMemberCondition.nickname,
            loginId = searchMemberCondition.loginId
        )

        // #2. entity <-> domain
        return searchedMember?.toDomain()
    }


}