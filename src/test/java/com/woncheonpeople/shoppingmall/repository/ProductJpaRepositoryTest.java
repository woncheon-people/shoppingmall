package com.woncheonpeople.shoppingmall.repository;

import com.woncheonpeople.shoppingmall.domain.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductJpaRepositoryTest {

    @Autowired
    ProductJpaRepository productRepository;

    @Test // 상품 저장테스트
    public void createProductTest(){
        Product product = new Product();
        product.setName("테스트 상품");
        product.setPrice(10000);
        product.setProductInfo("테스트 상품 상세 설명");
        product.setShippingInfo("테스트 배송 상세 설명");
        product.setOutOfStock(false);
//        product.getFilename("저장파일이름");
//        product.getFilepath("사진파일 경로");
//        product.setStocks(10);
//        product.setOutOfStock(1);

        Product savedProduct = productRepository.save(product);

        System.out.println(savedProduct.toString());
    }

    public void createProductList(){
        for(int i=1;i<=10;i++){
            Product product = new Product();
            product.setName("테스트 상품" + i);
            product.setPrice(10000 + i);
            product.setProductInfo("테스트 상품 상세 설명"+i);
            product.setShippingInfo("테스트 배송 상세 설명"+i);
//            product.setStocks(10);
//            product.setOutOfStock(1);
            Product savedProduct = productRepository.save(product);

        }
    }

//    @Test //상품명 조회 테스트
    public void findByProductNameTest(){
        this.createProductList();
        List<Product> itemList = productRepository.findByName("테스트 상품1");
        for(Product item : itemList){
            System.out.println(item.toString());
        }
    }



}
