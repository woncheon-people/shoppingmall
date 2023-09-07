package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemJpaRepository extends JpaRepository<CartItem, Long> {
}
