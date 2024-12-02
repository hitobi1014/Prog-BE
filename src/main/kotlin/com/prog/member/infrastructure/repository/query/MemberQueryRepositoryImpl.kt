package com.prog.member.infrastructure.repository.query

import com.prog.member.infrastructure.entity.MemberEntity
import com.prog.member.infrastructure.entity.QMemberEntity.memberEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MemberQueryRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory,
) : MemberQueryRepository {
    override fun search(nickname: String?, loginId: String?): MemberEntity? {
        return jpaQueryFactory.select(memberEntity)
            .from(memberEntity)
            .where(
                memberEntity.isDeleted.isFalse,
                nickname?.let { memberEntity.nickname.eq(nickname) },
                loginId?.let { memberEntity.loginId.eq(loginId) }
            ).fetchOne()
    }
}