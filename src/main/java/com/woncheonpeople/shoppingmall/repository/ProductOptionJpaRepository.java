package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.product.ProductImage;
import com.woncheonpeople.shoppingmall.domain.product.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOptionJpaRepository extends JpaRepository<ProductOption, Long> {
}
