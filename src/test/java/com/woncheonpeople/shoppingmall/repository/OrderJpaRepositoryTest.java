package com.woncheonpeople.shoppingmall.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberRepository;

    @Autowired
    private OrderJpaRepository orderRepository;

    @Autowired
    private ProductJpaRepository productRepository;

    @Test
//    @Transactional
    void save() {
        Member member = new Member("홍길동");
        Product productA = new Product("상품 A");
        Product productB = new Product("상품 B");
        memberRepository.save(member);
        productRepository.save(productA);
        productRepository.save(productB);
    }
}
