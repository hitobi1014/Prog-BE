package com.prog.member.infrastructure.entity

import jakarta.persistence.Embeddable

@Embeddable
class GithubInfoEntity(
    val githubId: String? = null,
    val githubEmail: String? = null,
    val githubNickname: String? = null,
)