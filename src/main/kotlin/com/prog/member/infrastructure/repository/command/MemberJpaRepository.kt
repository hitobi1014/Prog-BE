package com.prog.member.infrastructure.repository.command

import com.prog.member.infrastructure.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberEntity, Long>