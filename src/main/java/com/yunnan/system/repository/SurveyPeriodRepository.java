package com.yunnan.system.repository;

import com.yunnan.system.entity.SurveyPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SurveyPeriodRepository extends JpaRepository<SurveyPeriod, Long> {
    Optional<SurveyPeriod> findByPeriodCode(String periodCode);
    List<SurveyPeriod> findByActiveTrue();
}