package com.woncheonpeople.shoppingmall.domain.order;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import com.woncheonpeople.shoppingmall.domain.product.ProductOption;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "order_items")
@RequiredArgsConstructor
@Getter @Setter
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Order.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", updatable = false)
    private Order order;

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", updatable = false)
    private Product product;

    @ManyToOne(targetEntity = ProductOption.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_option_id", updatable = false)
    private ProductOption option;

    @Column
    private int quantity;
}
