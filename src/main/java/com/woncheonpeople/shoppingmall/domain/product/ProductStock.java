package com.woncheonpeople.shoppingmall.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter @Setter
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String warehouse; // 창고이름

    @Column
    private int quantity; // 상품 수량

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    private Product product;
}
