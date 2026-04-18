package com.yunnan.system.service;

import com.yunnan.system.entity.SurveyPeriod;

import java.util.List;

public interface SurveyPeriodService {
    SurveyPeriod create(SurveyPeriod surveyPeriod);
    SurveyPeriod update(Long id, SurveyPeriod surveyPeriod);
    List<SurveyPeriod> listAll();
}