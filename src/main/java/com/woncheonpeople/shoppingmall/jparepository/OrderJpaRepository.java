package com.woncheonpeople.shoppingmall.jparepository;

import com.woncheonpeople.shoppingmall.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<Order, Long> {
}
