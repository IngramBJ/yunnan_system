package com.yunnan.system.repository;

import com.yunnan.system.entity.Report;
import com.yunnan.system.entity.enums.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByEnterpriseId(Long enterpriseId);
    List<Report> findBySurveyPeriodId(Long surveyPeriodId);
    List<Report> findByStatus(ReportStatus status);
}