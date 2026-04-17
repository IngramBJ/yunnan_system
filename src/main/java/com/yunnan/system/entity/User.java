package com.yunnan.system.entity;

import com.yunnan.system.entity.enums.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sys_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserType userType;

    @Column(length = 50)
    private String realName;

    @Column(length = 50)
    private String districtCode;

    @Column(length = 50)
    private String districtName;

    @Column(nullable = false)
    private Boolean enabled = true;

    private LocalDateTime createdAt = LocalDateTime.now();
}