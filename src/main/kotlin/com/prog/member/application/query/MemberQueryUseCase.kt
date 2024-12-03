package com.prog.member.application.query

import com.prog.member.domain.aggregates.Member
import com.prog.member.dto.request.MemberSearchConditionRequest

interface MemberQueryUseCase {
    /**
     *   1. 회원 1명 정보 가져오기
     *        - byMemberId
     *        - byLoginId
     *        - byNickname
     *     2. 회원 로그인
     */
    fun getMemberById(id: Long): Member
    fun searchByCondition(searchMemberCondition: MemberSearchConditionRequest): Member?
}