package com.prog.member.infrastructure.repository.querydsl

import com.prog.member.infrastructure.persistence.entity.MemberEntity

interface MemberQueryRepository {
    fun search(nickname: String?, loginId: String?): MemberEntity?
}