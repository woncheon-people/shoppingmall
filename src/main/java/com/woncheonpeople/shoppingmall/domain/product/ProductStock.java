package com.woncheonpeople.shoppingmall.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String warehouse; // 창고이름

    private int quantity; // 상품 수량

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    private Product product;
}
