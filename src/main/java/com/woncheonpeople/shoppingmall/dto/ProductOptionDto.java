package com.woncheonpeople.shoppingmall.dto;

import com.woncheonpeople.shoppingmall.domain.product.ProductOption;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ProductOptionDto {
    private Long id;
    private String value;

    public static ProductOptionDto fromEntity(ProductOption entity) {
        return new ProductOptionDto(entity.getId(), entity.getValue());
    }
}
