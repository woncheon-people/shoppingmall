package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.product.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageJpaRepository extends JpaRepository<ProductImage, Long> {
}
