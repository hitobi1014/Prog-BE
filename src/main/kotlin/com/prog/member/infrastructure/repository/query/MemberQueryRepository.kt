package com.prog.member.infrastructure.repository.query

import com.prog.member.infrastructure.entity.MemberEntity

interface MemberQueryRepository {
    fun search(nickname: String?, loginId: String?): MemberEntity?
    fun findById(id: Long): MemberEntity
}