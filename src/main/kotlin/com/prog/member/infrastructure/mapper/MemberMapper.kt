package com.prog.member.infrastructure.mapper

import com.prog.member.domain.aggregates.Member
import com.prog.member.domain.valueobjects.GitHubInfo
import com.prog.member.infrastructure.entity.GithubInfoEntity
import com.prog.member.infrastructure.entity.MemberEntity

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

fun Member.toEntity(): MemberEntity {
    return MemberEntity(
        loginId = this.loginId,
        password = this.password,
        provider = this.provider,
        name = this.name,
        nickname = this.nickname,
        description = this.description,
        githubInfoEntity = this.gitHubInfo?.toEntity(),
        profileUrl = this.profileUrl,
        id = this.id
    )
}

fun GithubInfoEntity.toDomain(): GitHubInfo {
    return GitHubInfo(
        githubId = this.githubId,
        githubEmail = this.githubEmail,
        githubNickname = this.githubNickname
    )
}

fun GitHubInfo.toEntity(): GithubInfoEntity {
    return GithubInfoEntity(
        githubId = this.githubId,
        githubEmail = this.githubEmail,
        githubNickname = this.githubNickname
    )
}