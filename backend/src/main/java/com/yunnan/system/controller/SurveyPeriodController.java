package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.entity.SurveyPeriod;
import com.yunnan.system.service.SurveyPeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/survey-period")
public class SurveyPeriodController {

    private final SurveyPeriodService surveyPeriodService;

    public SurveyPeriodController(SurveyPeriodService surveyPeriodService) {
        this.surveyPeriodService = surveyPeriodService;
    }

    @PostMapping
    public ApiResponse<SurveyPeriod> create(@RequestBody SurveyPeriod surveyPeriod) {
        return ApiResponse.ok(surveyPeriodService.create(surveyPeriod));
    }

    @PutMapping("/{id}")
    public ApiResponse<SurveyPeriod> update(@PathVariable Long id, @RequestBody SurveyPeriod surveyPeriod) {
        return ApiResponse.ok(surveyPeriodService.update(id, surveyPeriod));
    }

    @GetMapping
    public ApiResponse<List<SurveyPeriod>> listAll() {
        return ApiResponse.ok(surveyPeriodService.listAll());
    }
}