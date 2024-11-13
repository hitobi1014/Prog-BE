package com.prog.member.domain.model.aggregates

import com.prog.member.domain.model.enums.Provider
import com.prog.member.domain.model.valueobjects.GitHubInfo

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
) {

    // TODO 유효성 검증
}