package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.member.Address;
import com.woncheonpeople.shoppingmall.domain.member.Member;
import com.woncheonpeople.shoppingmall.domain.member.Sex;
import com.woncheonpeople.shoppingmall.repository.MemberJpaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Test
    // @Transactional  << 이거를 사용하려면 반드시 알맞은 PlatformTransactionlManager 구현체가 정의되어 있어야한다. 그렇지 않으면 DB 연결이 안 끊겨서 다음 명령 시 커넥션 오류 남.
    // https://imiyoungman.tistory.com/9
    void save(){
        Address address = new Address("06022", "서울특별시 강남구 청담동", "안녕아파트 103동 908호");
        Member member = new Member(2L, "아무개", Sex.male, address, "010-1234-5678", "admin", "1234");
        Member result = memberJpaRepository.save(member);
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findById(){
        Optional<Member> result = memberJpaRepository.findById(1L);
        assertThat(result).isNotEmpty();
    }

    @Test
    @Transactional
    void delete(){
    }
}
