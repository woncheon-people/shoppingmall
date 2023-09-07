package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
}
