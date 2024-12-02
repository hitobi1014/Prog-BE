package com.prog.member.infrastructure.repository.query

import com.prog.common.CustomRepositoryTest
import com.prog.member.infrastructure.entity.MemberEntity
import com.prog.member.infrastructure.repository.command.MemberJpaRepository
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@CustomRepositoryTest
class MemberQueryRepositoryImplTest @Autowired constructor(
    private val memberQuerydslRepository: MemberQueryRepository,
    private val jpaMemberRepository: MemberJpaRepository,
) {
    @Test
    @DisplayName("동적파라미터 이용하여 탈퇴하지 않은 member 조회")
    fun dynamicQueryTest() {
        //given
        val name = "테스트유저"
        val nickname = "한강"
        val loginId = "test"
        val member = MemberEntity(
            loginId = loginId,
            password = "password",
            name = name,
            nickname = nickname,
        )
        jpaMemberRepository.save(member)

        //when
        val findByNickname = memberQuerydslRepository.search(nickname = nickname, loginId = null)
        val findByLoginId = memberQuerydslRepository.search(loginId = loginId, nickname = null)
        val find = memberQuerydslRepository.search(nickname = nickname, loginId = loginId)

        //then
        assertThat(findByNickname?.name).isEqualTo(name)
        assertThat(findByLoginId?.name).isEqualTo(name)
        assertThat(findByNickname?.name).isEqualTo(findByLoginId?.name)
        assertThat(find?.id).isEqualTo(findByLoginId?.id)
    }

    @Test
    @DisplayName("닉네임으로 조회, 탈퇴된 회원은 나오면 안된다")
    fun findByNicknameTest() {
        //given
        val name = "테스트유저"
        val nickname = "한강"
        val loginId = "test"
        val member = MemberEntity(
            loginId = loginId,
            password = "password",
            name = name,
            nickname = nickname,
        )
        jpaMemberRepository.save(member)

        //when
        val findMember = memberQuerydslRepository.search(nickname = nickname, loginId = null)
        findMember?.deleteData()
        findMember?.let { jpaMemberRepository.save(it) }

        val find = memberQuerydslRepository.search(nickname = nickname, loginId = null)

        //then
        assertThat(find).isNull()
    }


}