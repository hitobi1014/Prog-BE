package com.prog.member.application.port.output

import com.prog.member.domain.model.aggregates.Member

interface MemberQueryPort {
    // Member 반환하는 Query
    fun findById(id: Long): Member?
    fun search(nickname: String? = null, loginId: String? = null): Member?
}