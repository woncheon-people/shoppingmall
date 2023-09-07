package com.woncheonpeople.shoppingmall.jparepository;

import com.woncheonpeople.shoppingmall.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
