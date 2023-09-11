package com.woncheonpeople.shoppingmall.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UpdateProductDto {
    private String name;
    private Integer price;
    private String productInfo;
    private String shippingInfo;
    private List<String> images;
    private List<String> options;
}
