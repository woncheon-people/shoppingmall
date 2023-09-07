package com.woncheonpeople.shoppingmall.domain.product;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class ProductOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_value")
    private String value; // 옵션

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    private Product product;
}
