package com.prog.member.dto.request

data class SignupMemberRequest(
    val loginId: String,
    val password: String,
    val name: String,
    val nickname: String,
    val description: String?,
    val profileUrl: String?,
)
