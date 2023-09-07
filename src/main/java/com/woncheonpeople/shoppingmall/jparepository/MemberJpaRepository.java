package com.woncheonpeople.shoppingmall.jparepository;

import com.woncheonpeople.shoppingmall.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
}
