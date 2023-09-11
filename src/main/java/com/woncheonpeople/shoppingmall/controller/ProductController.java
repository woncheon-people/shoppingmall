package com.woncheonpeople.shoppingmall.controller;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import com.woncheonpeople.shoppingmall.dto.CreateProductDto;
import com.woncheonpeople.shoppingmall.dto.ProductDto;
import com.woncheonpeople.shoppingmall.dto.ProductListItemDto;
import com.woncheonpeople.shoppingmall.dto.UpdateProductDto;
import com.woncheonpeople.shoppingmall.service.sangsu.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity addProduct(@RequestBody CreateProductDto body) {
        Product product = productService.addProduct(body);
        return ResponseEntity.created(URI.create("/api/products/" + product.getId())).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductListItemDto>> getProducts() {
        List<ProductListItemDto> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        ProductDto product = productService.getProductOneById(id);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody UpdateProductDto body) {
        productService.updateProduct(id, body);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}
