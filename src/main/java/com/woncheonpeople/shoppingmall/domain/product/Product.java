package com.woncheonpeople.shoppingmall.domain.product;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String productInfo;

    @Column
    private String shippingInfo;

    @Column
    private boolean isOutOfStock;

    @OneToMany(mappedBy = "product", targetEntity = ProductImage.class, cascade = CascadeType.PERSIST)
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", targetEntity = ProductStock.class, cascade = CascadeType.PERSIST)
    private List<ProductStock> stocks = new ArrayList<>();// 상품 재고

    @OneToMany(mappedBy = "product", targetEntity = ProductOption.class, cascade = CascadeType.PERSIST)
    private List<ProductOption> options = new ArrayList<>();// 상품 옵션
}

