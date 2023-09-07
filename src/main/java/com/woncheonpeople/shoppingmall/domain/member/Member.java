package com.woncheonpeople.shoppingmall.domain.member;

import jakarta.persistence.*;
import lombok.*;

@Entity
@RequiredArgsConstructor
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Embedded
    private Address address;

    @Column
    private String phoneNumber;

    @Column
    private String loginId;

    @Column
    private String password;
}
