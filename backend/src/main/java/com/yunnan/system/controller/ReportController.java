package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.dto.ReportSubmitRequest;
import com.yunnan.system.entity.Report;
import com.yunnan.system.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/submit")
    public ApiResponse<Report> submit(@RequestBody @Valid ReportSubmitRequest request) {
        return ApiResponse.ok(reportService.submit(request));
    }

    @PostMapping("/{id}/approve")
    public ApiResponse<Report> approve(@PathVariable Long id, @RequestParam(required = false) String remark) {
        return ApiResponse.ok(reportService.approve(id, remark));
    }

    @PostMapping("/{id}/return")
    public ApiResponse<Report> returnBack(@PathVariable Long id, @RequestParam(required = false) String remark) {
        return ApiResponse.ok(reportService.returnBack(id, remark));
    }

    @GetMapping
    public ApiResponse<List<Report>> listAll() {
        return ApiResponse.ok(reportService.listAll());
    }

    @GetMapping("/enterprise/{enterpriseId}")
    public ApiResponse<List<Report>> listByEnterprise(@PathVariable Long enterpriseId) {
        return ApiResponse.ok(reportService.listByEnterprise(enterpriseId));
    }
}