package com.yunnan.system.service;

import com.yunnan.system.dto.ReportSubmitRequest;
import com.yunnan.system.entity.Report;

import java.util.List;

public interface ReportService {
    Report submit(ReportSubmitRequest request);
    Report approve(Long id, String remark);
    Report returnBack(Long id, String remark);
    List<Report> listAll();
    List<Report> listByEnterprise(Long enterpriseId);
}