package com.yunnan.system.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NoticeSaveRequest {
    @NotBlank(message = "通知标题不能为空")
    private String title;

    @NotBlank(message = "通知内容不能为空")
    private String content;
}