package com.woncheonpeople.shoppingmall.dto;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductListItemDto {
    private Long id;
    private String name;
    private Integer price;
    private List<String> images;

    public static ProductListItemDto fromEntity(Product entity) {
        return new ProductListItemDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getImages().stream().map(e -> e.getImageUrl()).toList());
    }
}
