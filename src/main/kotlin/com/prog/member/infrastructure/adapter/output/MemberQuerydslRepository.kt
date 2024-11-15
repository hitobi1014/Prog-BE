package com.prog.member.infrastructure.adapter.output

import com.prog.member.application.port.output.MemberRepository
import com.prog.member.infrastructure.persistence.entity.MemberEntity
import com.prog.member.infrastructure.persistence.entity.QMemberEntity.memberEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MemberQuerydslRepository(
    private val jpaQueryFactory: JPAQueryFactory,
) : MemberRepository {
    //    @Query("select m from MemberEntity m where m.id = :id and m.isDeleted = false")
    /**
     * 동적 파라미터를 활용하여 "탈퇴"하지 않은 회원 조회
     * @param nickname: 닉네임
     * @param loginId: 로그인 ID
     */
    override fun find(nickname: String?, loginId: String?): MemberEntity? {
        return jpaQueryFactory.select(memberEntity)
            .from(memberEntity)
            .where(
                memberEntity.isDeleted.isFalse,
                nickname?.let { memberEntity.nickname.eq(nickname) },
                loginId?.let { memberEntity.loginId.eq(loginId) }
            ).fetchOne()
    }
}