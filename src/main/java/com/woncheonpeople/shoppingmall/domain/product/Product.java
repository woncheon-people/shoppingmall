package com.woncheonpeople.shoppingmall.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

    @AllArgsConstructor // Parameter 로 모든 변수를 받는 생성자
    @NoArgsConstructor // Parameter 가 없는 생성자
    @Entity//Jpa에서 관리하는 클래스로 테이블과 자동매핑
    @Data //Lombok을 이용하여 해당 필드의 getter,setter 자동 생성
    public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id; //상품 고유번호
        private String name; // 상품 이름
        private int price;// 상품 가격
        private String productInfo;//상품 정보
        private String shippingInfo;//배송 정보

        private boolean isOutOfStock; // 상품 판매여부(0 : 판매중 / 1: 품절)
//        private String filename; // 상품 사진 파일 이름
//        private String filepath;// 상품 사진 파일 경로


        @OneToMany(mappedBy = "product", targetEntity = ProductOption.class, cascade = CascadeType.PERSIST)
        private List<ProductStock> stocks = new ArrayList<>();// 상품 재고

        @OneToMany(mappedBy = "product", targetEntity = ProductOption.class, cascade = CascadeType.PERSIST)
        private List<ProductOption> options = new ArrayList<>();// 상품 옵션
    }

