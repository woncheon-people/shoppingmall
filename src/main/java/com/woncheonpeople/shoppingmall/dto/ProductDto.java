package com.woncheonpeople.shoppingmall.dto;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private int price;
    private String productInfo;
    private String shippingInfo;
    private boolean isOutOfStock;
    private List<String> images;
    private List<ProductOptionDto> options;

    public static ProductDto fromEntity(Product entity) {
        return new ProductDto(entity.getId(), entity.getName(), entity.getPrice(), entity.getProductInfo(), entity.getShippingInfo(), entity.isOutOfStock(), entity.getImageValues(), entity.getOptionValues());
    }
}
