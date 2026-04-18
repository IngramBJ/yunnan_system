package com.yunnan.system.service.impl;

import com.yunnan.system.common.exception.BizException;
import com.yunnan.system.entity.SurveyPeriod;
import com.yunnan.system.repository.SurveyPeriodRepository;
import com.yunnan.system.service.SurveyPeriodService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyPeriodServiceImpl implements SurveyPeriodService {

    private final SurveyPeriodRepository surveyPeriodRepository;

    public SurveyPeriodServiceImpl(SurveyPeriodRepository surveyPeriodRepository) {
        this.surveyPeriodRepository = surveyPeriodRepository;
    }

    @Override
    public SurveyPeriod create(SurveyPeriod surveyPeriod) {
        return surveyPeriodRepository.save(surveyPeriod);
    }

    @Override
    public SurveyPeriod update(Long id, SurveyPeriod surveyPeriod) {
        SurveyPeriod old = surveyPeriodRepository.findById(id)
                .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "调查期不存在"));
        old.setPeriodCode(surveyPeriod.getPeriodCode());
        old.setStartDate(surveyPeriod.getStartDate());
        old.setEndDate(surveyPeriod.getEndDate());
        old.setActive(surveyPeriod.getActive());
        return surveyPeriodRepository.save(old);
    }

    @Override
    public List<SurveyPeriod> listAll() {
        return surveyPeriodRepository.findAll();
    }
}