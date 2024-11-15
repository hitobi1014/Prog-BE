package com.prog.member.application.port.output

import com.prog.member.infrastructure.persistence.entity.MemberEntity

interface MemberRepository {
    fun find(nickname: String? = null, loginId: String? = null): MemberEntity?
}