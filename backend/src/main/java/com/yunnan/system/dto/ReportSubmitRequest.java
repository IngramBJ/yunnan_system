package com.yunnan.system.dto;

import jakarta.validation.constraints.NotNull;

public class ReportSubmitRequest {
    @NotNull(message = "企业ID不能为空")
    private Long enterpriseId;

    @NotNull(message = "调查期ID不能为空")
    private Long surveyPeriodId;

    @NotNull(message = "建档期就业人数不能为空")
    private Integer baseEmploymentCount;

    @NotNull(message = "调查期就业人数不能为空")
    private Integer currentEmploymentCount;

    @NotNull(message = "其他原因数量不能为空")
    private Integer otherReasonCount;

    private String decreaseType;
    private String mainReason;
    private String mainReasonDesc;
    private String secondReason;
    private String secondReasonDesc;
    private String thirdReason;
    private String thirdReasonDesc;

    public ReportSubmitRequest() {
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
}