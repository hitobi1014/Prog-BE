package com.prog.member.domain.repository

import com.prog.member.infrastructure.persistence.entity.MemberEntity


interface MemberQueryRepository {
    fun findByNickname(nickname: String): MemberEntity?
    fun findByLoginId(loginId: String): MemberEntity?
    fun findByIdAndNotDeleted(id: Long): MemberEntity?

}