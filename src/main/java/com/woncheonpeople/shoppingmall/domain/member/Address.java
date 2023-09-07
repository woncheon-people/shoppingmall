package com.woncheonpeople.shoppingmall.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@RequiredArgsConstructor
@Getter @Setter
public class Address {
    @Column
    private String postalCode;

    @Column
    private String address1;

    @Column
    private String address2;
}
