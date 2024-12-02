package com.prog.member.domain.aggregates

import com.prog.member.domain.enum.Provider
import com.prog.member.domain.valueobjects.GitHubInfo

data class Member(
    val id: Long? = null,
    val loginId: String,
    val password: String,
    val provider: Provider? = null,
    val name: String,
    val nickname: String,
    val description: String? = null,
    val gitHubInfo: GitHubInfo? = null,
    val profileUrl: String? = null,
)