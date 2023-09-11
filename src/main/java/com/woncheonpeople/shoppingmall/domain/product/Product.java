package com.woncheonpeople.shoppingmall.domain.product;

import com.woncheonpeople.shoppingmall.dto.ProductOptionDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private int price;

    @Column
    @NonNull
    private String productInfo;

    @Column
    @NonNull
    private String shippingInfo;

    @Column
    @NonNull
    private boolean isOutOfStock;

    @OneToMany(mappedBy = "product", targetEntity = ProductImage.class, cascade = CascadeType.PERSIST)
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "product", targetEntity = ProductStock.class, cascade = CascadeType.PERSIST)
    private List<ProductStock> stocks = new ArrayList<>();// 상품 재고

    @OneToMany(mappedBy = "product", targetEntity = ProductOption.class, cascade = CascadeType.PERSIST)
    private List<ProductOption> options = new ArrayList<>();// 상품 옵션

    public List<String> getImageValues() {
        return images.stream().map(e -> e.getImageUrl()).toList();
    }

    public List<ProductOptionDto> getOptionValues() {
        return options.stream().map(e -> ProductOptionDto.fromEntity(e)).toList();
    }
}

