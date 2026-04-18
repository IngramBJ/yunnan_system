package com.yunnan.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnterpriseSaveRequest {
    @NotBlank(message = "组织机构代码不能为空")
    private String orgCode;

    @NotBlank(message = "企业名称不能为空")
    private String enterpriseName;

    private String enterpriseNature;
    private String industry;
    private String businessScope;
    private String contactPerson;
    private String address;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
    private String districtCode;
    private String districtName;
}