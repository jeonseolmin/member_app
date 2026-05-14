package com.my.member_app.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity @Table(name = "members") @Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 40)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false, length = 255)
    private String addr;

}
