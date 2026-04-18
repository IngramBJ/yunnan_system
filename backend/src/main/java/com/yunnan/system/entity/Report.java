package com.yunnan.system.entity;

import com.yunnan.system.entity.enums.ReportStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "enterprise_report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long enterpriseId;
    private Long surveyPeriodId;

    private Integer baseEmploymentCount;
    private Integer currentEmploymentCount;
    private Integer otherReasonCount;

    @Enumerated(EnumType.STRING)
    private ReportStatus status = ReportStatus.DRAFT;

    private String decreaseType;
    private String mainReason;
    private String mainReasonDesc;
    private String secondReason;
    private String secondReasonDesc;
    private String thirdReason;
    private String thirdReasonDesc;

    @Column(length = 500)
    private String remark;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}