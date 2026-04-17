package com.yunnan.system.entity;

import com.yunnan.system.entity.enums.EnterpriseStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String orgCode;

    @Column(nullable = false, length = 200)
    private String enterpriseName;

    @Column(length = 100)
    private String enterpriseNature;

    @Column(length = 100)
    private String industry;

    @Column(length = 200)
    private String businessScope;

    @Column(length = 100)
    private String contactPerson;

    @Column(length = 200)
    private String address;

    @Column(length = 20)
    private String postalCode;

    @Column(length = 50)
    private String phone;

    @Column(length = 50)
    private String fax;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String districtCode;

    @Column(length = 100)
    private String districtName;

    @Enumerated(EnumType.STRING)
    private EnterpriseStatus status = EnterpriseStatus.DRAFT;

    @Column(length = 500)
    private String reviewRemark;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}