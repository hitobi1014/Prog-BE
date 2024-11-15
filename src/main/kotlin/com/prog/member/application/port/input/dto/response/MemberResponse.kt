package com.prog.member.application.port.input.dto.response

data class MemberResponse(
    val id: Long,
    val loginId: String,
    val name: String,
    val nickname: String,
    val description: String? = null,
    val githubId: String? = null,
    val githubEmail: String? = null,
    val githubNickname: String? = null,
    val profileUrl: String? = null,
)
