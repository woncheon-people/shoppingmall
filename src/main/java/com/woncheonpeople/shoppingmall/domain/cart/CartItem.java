package com.woncheonpeople.shoppingmall.domain.cart;

import com.woncheonpeople.shoppingmall.domain.member.Member;
import com.woncheonpeople.shoppingmall.domain.product.Product;
import com.woncheonpeople.shoppingmall.domain.product.ProductOption;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter @Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", updatable = false)
    private Member member;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", updatable = false)
    private Product product;

    @ManyToOne(targetEntity = ProductOption.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", updatable = false)
    private ProductOption option;

    @Column
    private int quantity;
}
