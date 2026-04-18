package com.yunnan.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
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
}