package com.prog.member.infrastructure.repository

import com.prog.member.infrastructure.persistence.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository : JpaRepository<MemberEntity, Long>