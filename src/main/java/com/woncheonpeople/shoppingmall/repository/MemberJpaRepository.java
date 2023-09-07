package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
