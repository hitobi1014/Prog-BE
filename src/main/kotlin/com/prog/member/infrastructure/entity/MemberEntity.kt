package com.prog.member.infrastructure.entity

import com.prog.member.domain.enum.Provider
import com.prog.shared.entity.DeleteEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment

@Entity
@Table(name = "prog_member")
class MemberEntity(
    @Column(length = 100)
    @Comment("로그인ID")
    val loginId: String,

    @Column(length = 64)
    @Comment("비밀번호")
    val password: String,

    @Enumerated(EnumType.STRING)
    @Comment("소셜로그인 사이트")
    val provider: Provider? = null,

    @Column(length = 30)
    @Comment("이름")
    val name: String,

    @Column(length = 30)
    @Comment("닉네임")
    val nickname: String,

    @Column(length = 150)
    @Comment("한줄소개")
    val description: String? = null,

    @Embedded
    val githubInfoEntity: GithubInfoEntity? = null,

    @Comment("프로필")
    val profileUrl: String? = null,

    // 나중에 역할 넣으려면 넣기

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    @Comment("회원ID")
    val id: Long? = null,
) : DeleteEntity()