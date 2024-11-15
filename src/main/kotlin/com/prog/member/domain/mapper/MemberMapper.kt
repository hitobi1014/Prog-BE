package com.prog.member.domain.mapper

import com.prog.member.application.port.input.dto.response.MemberResponse
import com.prog.member.domain.model.aggregates.Member
import com.prog.member.domain.model.valueobjects.GitHubInfo
import com.prog.member.infrastructure.persistence.entity.GithubInfoEntity
import com.prog.member.infrastructure.persistence.entity.MemberEntity

// dto -> domain

// domain -> dto
fun Member.toDto(): MemberResponse {
    return MemberResponse(
        id = this.id!!,
        loginId = this.loginId,
        name = this.name,
        nickname = this.nickname,
        description = this.description,
        githubId = this.gitHubInfo?.githubId,
        githubEmail = this.gitHubInfo?.githubEmail,
        githubNickname = this.gitHubInfo?.githubNickname,
        profileUrl = this.profileUrl,
    )
}

// domain -> entity
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

fun GitHubInfo.toEntity(): GithubInfoEntity {
    return GithubInfoEntity(
        githubId = this.githubId,
        githubEmail = this.githubEmail,
        githubNickname = this.githubNickname,
    )
}

// entity -> domain
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

fun GithubInfoEntity.toDomain(): GitHubInfo {
    return GitHubInfo(
        githubId = this.githubId,
        githubEmail = this.githubEmail,
        githubNickname = this.githubNickname,
    )
}