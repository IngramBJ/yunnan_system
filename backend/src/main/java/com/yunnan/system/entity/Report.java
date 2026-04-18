package com.yunnan.system.entity;

import com.yunnan.system.entity.enums.ReportStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    public Report() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getSurveyPeriodId() {
        return surveyPeriodId;
    }

    public void setSurveyPeriodId(Long surveyPeriodId) {
        this.surveyPeriodId = surveyPeriodId;
    }

    public Integer getBaseEmploymentCount() {
        return baseEmploymentCount;
    }

    public void setBaseEmploymentCount(Integer baseEmploymentCount) {
        this.baseEmploymentCount = baseEmploymentCount;
    }

    public Integer getCurrentEmploymentCount() {
        return currentEmploymentCount;
    }

    public void setCurrentEmploymentCount(Integer currentEmploymentCount) {
        this.currentEmploymentCount = currentEmploymentCount;
    }

    public Integer getOtherReasonCount() {
        return otherReasonCount;
    }

    public void setOtherReasonCount(Integer otherReasonCount) {
        this.otherReasonCount = otherReasonCount;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getDecreaseType() {
        return decreaseType;
    }

    public void setDecreaseType(String decreaseType) {
        this.decreaseType = decreaseType;
    }

    public String getMainReason() {
        return mainReason;
    }

    public void setMainReason(String mainReason) {
        this.mainReason = mainReason;
    }

    public String getMainReasonDesc() {
        return mainReasonDesc;
    }

    public void setMainReasonDesc(String mainReasonDesc) {
        this.mainReasonDesc = mainReasonDesc;
    }

    public String getSecondReason() {
        return secondReason;
    }

    public void setSecondReason(String secondReason) {
        this.secondReason = secondReason;
    }

    public String getSecondReasonDesc() {
        return secondReasonDesc;
    }

    public void setSecondReasonDesc(String secondReasonDesc) {
        this.secondReasonDesc = secondReasonDesc;
    }

    public String getThirdReason() {
        return thirdReason;
    }

    public void setThirdReason(String thirdReason) {
        this.thirdReason = thirdReason;
    }

    public String getThirdReasonDesc() {
        return thirdReasonDesc;
    }

    public void setThirdReasonDesc(String thirdReasonDesc) {
        this.thirdReasonDesc = thirdReasonDesc;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}