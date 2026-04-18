package com.yunnan.system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reason_dict")
public class ReasonDict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String reasonDesc;

    @Column(length = 200)
    private String superReason;

    public ReasonDict() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }

    public String getSuperReason() {
        return superReason;
    }

    public void setSuperReason(String superReason) {
        this.superReason = superReason;
    }
}