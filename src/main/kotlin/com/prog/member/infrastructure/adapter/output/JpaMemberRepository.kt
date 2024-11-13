package com.prog.member.infrastructure.adapter.output

import com.prog.member.domain.repository.MemberQueryRepository
import com.prog.member.infrastructure.persistence.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface JpaMemberRepository : JpaRepository<MemberEntity, Long>, MemberQueryRepository {
    override fun findByNickname(nickname: String): MemberEntity?
    override fun findByLoginId(loginId: String): MemberEntity?

    @Query("select m from MemberEntity m where m.id = :id and m.isDeleted = false")
    override fun findByIdAndNotDeleted(@Param("id") id: Long): MemberEntity?
}