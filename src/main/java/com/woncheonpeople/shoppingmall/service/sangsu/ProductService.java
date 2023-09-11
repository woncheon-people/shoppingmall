package com.woncheonpeople.shoppingmall.service.sangsu;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import com.woncheonpeople.shoppingmall.domain.product.ProductImage;
import com.woncheonpeople.shoppingmall.domain.product.ProductOption;
import com.woncheonpeople.shoppingmall.dto.CreateProductDto;
import com.woncheonpeople.shoppingmall.dto.ProductDto;
import com.woncheonpeople.shoppingmall.dto.ProductListItemDto;
import com.woncheonpeople.shoppingmall.dto.UpdateProductDto;
import com.woncheonpeople.shoppingmall.repository.ProductImageJpaRepository;
import com.woncheonpeople.shoppingmall.repository.ProductJpaRepository;
import com.woncheonpeople.shoppingmall.repository.ProductOptionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductJpaRepository productRepository;
    private final ProductImageJpaRepository productImageJpaRepository;
    private final ProductOptionJpaRepository productOptionJpaRepository;

    @Transactional()
    public Product addProduct(CreateProductDto body) {
        Product newProduct = new Product(body.getName(), body.getPrice(), body.getProductInfo(), body.getShippingInfo(), true);
        final Product savedProduct = productRepository.save(newProduct);

        for (String url: body.getImages()) {
            ProductImage productImage = new ProductImage(newProduct, url);
            productImageJpaRepository.save(productImage);
        }

        for (String option: body.getOptions()) {
            ProductOption productOption = new ProductOption(newProduct, option);
            productOptionJpaRepository.save(productOption);
        }

        return savedProduct;
    }

    public List<ProductListItemDto> getProducts() {
        return productRepository.findAll().stream().map(e -> ProductListItemDto.fromEntity(e)).toList();
    }

    public ProductDto getProductOneById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException());

        return ProductDto.fromEntity(product);
    }

    public Product updateProduct(Long productId, UpdateProductDto body) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException());

        product.setName(body.getName());
        product.setPrice(body.getPrice());
        product.setProductInfo(body.getProductInfo());
        product.setShippingInfo(body.getShippingInfo());
        product.setImages(body.getImages().stream().map(url -> new ProductImage(product, url)).toList());
        product.setOptions(body.getOptions().stream().map(option -> new ProductOption(product, option)).toList());

        return productRepository.save(product);
    }

    @Transactional
    public void deleteProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException());

        productImageJpaRepository.deleteByProduct(product);
        productOptionJpaRepository.deleteByProduct(product);
        productRepository.deleteById(productId);
    }
}
