package com.prog.member.application.port.input

import com.prog.member.application.port.input.dto.response.MemberResponse

interface MemberQueryUseCase {
    /**
     *   1. 회원 1명 정보 가져오기
     *        - byMemberId
     *        - byLoginId
     *        - byNickname
     *     2. 회원 로그인
     */
    fun getMemberById(id: Long): MemberResponse
    fun getMemberByNickname(nickname: String): MemberResponse
    fun getMemberByLoginId(loginId: String): MemberResponse

    //    fun signUp(memberDto: MemberDto.Post?)
    //    fun getMyProfile(id: Int?): MemberDto.Response?
//    fun getProfile(id: Int?): MemberDto.Response?
//    fun getDetailProfile(id: Int?): MemberDto.DetailResponse?
//    fun checkEmail(email: String?)
//    fun checkNickname(id: Int?, nickname: String?)
}