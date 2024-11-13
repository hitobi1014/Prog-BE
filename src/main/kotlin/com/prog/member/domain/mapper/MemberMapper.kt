package com.prog.member.domain.mapper

import com.prog.member.domain.model.aggregates.Member
import com.prog.member.domain.model.valueobjects.GitHubInfo
import com.prog.member.infrastructure.persistence.entity.GithubInfoEntity
import com.prog.member.infrastructure.persistence.entity.MemberEntity


fun Member.toEntity(): MemberEntity {
    return MemberEntity(
        id = this.id,
        loginId = this.loginId,
        password = this.password,
        provider = this.provider,
        name = this.name,
        nickname = this.nickname,
        description = this.description,
        githubInfoEntity = this.gitHubInfo?.toEntity(),
        profileUrl = this.profileUrl,
    )

}

fun MemberEntity.toDomain(): Member {
    return Member(
        id = this.id,
        loginId = this.loginId,
        password = this.password,
        provider = this.provider,
        name = this.name,
        nickname = this.nickname,
        description = this.description,
        gitHubInfo = this.githubInfoEntity?.toDomain(),
        profileUrl = this.profileUrl,
    )
}

fun GitHubInfo.toEntity(): GithubInfoEntity {
    return GithubInfoEntity(
        githubId = this.githubId,
        githubEmail = this.githubEmail,
        githubNickname = this.githubNickname,
    )
}

fun GithubInfoEntity.toDomain(): GitHubInfo {
    return GitHubInfo(
        githubId = this.githubId,
        githubEmail = this.githubEmail,
        githubNickname = this.githubNickname,
    )
}