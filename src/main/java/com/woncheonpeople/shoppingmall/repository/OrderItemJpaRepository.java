package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemJpaRepository extends JpaRepository<OrderItem, Long> {
}
