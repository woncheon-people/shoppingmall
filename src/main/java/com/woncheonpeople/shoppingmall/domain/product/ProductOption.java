package com.woncheonpeople.shoppingmall.domain.product;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter @Setter
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @NonNull
    private Product product;

    @Column(name="product_value")
    @NonNull
    private String value; // 옵션
}
