package com.yunnan.system.service.impl;

import com.yunnan.system.common.exception.BizException;
import com.yunnan.system.dto.ReportSubmitRequest;
import com.yunnan.system.entity.Report;
import com.yunnan.system.entity.enums.ReportStatus;
import com.yunnan.system.repository.ReportRepository;
import com.yunnan.system.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Report submit(ReportSubmitRequest request) {
        if (request.getCurrentEmploymentCount() < request.getBaseEmploymentCount()) {
            if (request.getDecreaseType() == null || request.getMainReason() == null || request.getMainReasonDesc() == null) {
                throw new BizException(HttpStatus.BAD_REQUEST.value(),
                        "当调查期就业人数小于建档期时，就业人数减少类型、主要原因和说明必填");
            }
        }

        Report report = new Report();
        report.setEnterpriseId(request.getEnterpriseId());
        report.setSurveyPeriodId(request.getSurveyPeriodId());
        report.setBaseEmploymentCount(request.getBaseEmploymentCount());
        report.setCurrentEmploymentCount(request.getCurrentEmploymentCount());
        report.setOtherReasonCount(request.getOtherReasonCount());
        report.setDecreaseType(request.getDecreaseType());
        report.setMainReason(request.getMainReason());
        report.setMainReasonDesc(request.getMainReasonDesc());
        report.setSecondReason(request.getSecondReason());
        report.setSecondReasonDesc(request.getSecondReasonDesc());
        report.setThirdReason(request.getThirdReason());
        report.setThirdReasonDesc(request.getThirdReasonDesc());
        report.setStatus(ReportStatus.SUBMITTED);
        report.setUpdatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    @Override
    public Report approve(Long id, String remark) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "报表不存在"));
        report.setRemark(remark);
        report.setStatus(ReportStatus.PROVINCE_APPROVED);
        report.setUpdatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    @Override
    public Report returnBack(Long id, String remark) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "报表不存在"));
        report.setRemark(remark);
        report.setStatus(ReportStatus.PROVINCE_RETURNED);
        report.setUpdatedAt(LocalDateTime.now());
        return reportRepository.save(report);
    }

    @Override
    public List<Report> listAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> listByEnterprise(Long enterpriseId) {
        return reportRepository.findByEnterpriseId(enterpriseId);
    }
}