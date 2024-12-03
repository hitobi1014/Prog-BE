package com.prog.member.application.command

import com.prog.member.dto.request.SignupMemberRequest

interface MemberCommandUseCase {
    /*
    updateMember
    회원탈퇴
     */
    fun signUp(dto: SignupMemberRequest)
}