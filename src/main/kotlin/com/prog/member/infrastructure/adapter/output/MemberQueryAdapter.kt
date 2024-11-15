package com.prog.member.infrastructure.adapter.output

import com.prog.member.application.port.output.MemberQueryPort
import com.prog.member.domain.mapper.toDomain
import com.prog.member.domain.model.aggregates.Member
import com.prog.member.infrastructure.repository.MemberJpaRepository
import com.prog.member.infrastructure.repository.querydsl.MemberQueryRepository

class MemberQueryAdapter(
    private val memberQueryRepository: MemberQueryRepository,
    private val memberJpaRepository: MemberJpaRepository,
) : MemberQueryPort {

    override fun findById(id: Long): Member? {
        return memberJpaRepository.findById(id)
            .map { it.toDomain() }
            .orElse(null)
    }

    override fun search(nickname: String?, loginId: String?): Member? {
        return memberQueryRepository.search(nickname, loginId)?.toDomain()
    }
}