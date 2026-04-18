package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.dto.EnterpriseSaveRequest;
import com.yunnan.system.entity.Enterprise;
import com.yunnan.system.service.EnterpriseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping
    public ApiResponse<Enterprise> create(@RequestBody @Valid EnterpriseSaveRequest request) {
        return ApiResponse.ok(enterpriseService.saveOrUpdate(null, request));
    }

    @PutMapping("/{id}")
    public ApiResponse<Enterprise> update(@PathVariable Long id, @RequestBody @Valid EnterpriseSaveRequest request) {
        return ApiResponse.ok(enterpriseService.saveOrUpdate(id, request));
    }

    @PostMapping("/{id}/submit-review")
    public ApiResponse<Enterprise> submitForReview(@PathVariable Long id) {
        return ApiResponse.ok(enterpriseService.submitForReview(id));
    }

    @GetMapping
    public ApiResponse<List<Enterprise>> listAll() {
        return ApiResponse.ok(enterpriseService.listAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Enterprise> getById(@PathVariable Long id) {
        return ApiResponse.ok(enterpriseService.getById(id));
    }
}