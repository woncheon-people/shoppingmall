package com.woncheonpeople.shoppingmall.domain.member;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String postalCode;
    private String address1;
    private String address2;
}
