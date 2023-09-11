package com.woncheonpeople.shoppingmall.service.sangsu;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import com.woncheonpeople.shoppingmall.dto.CreateProductDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
//    @Transactional
    void addProductTest() {
        CreateProductDto body = new CreateProductDto("상품 A", 10000, "기본 티셔츠", "배송비 2500원 / 롯데택배", List.of("https://www.woncheonpeople.com/static/products/1/01.png", "https://www.woncheonpeople.com/static/products/1/02.png"), List.of("WHITE M", "WHITE L", "BLACK M", "BLACK L"));
        Product saved = productService.addProduct(body);
        Assertions.assertThat(saved.getName()).isEqualTo(body.getName());
    }

}
