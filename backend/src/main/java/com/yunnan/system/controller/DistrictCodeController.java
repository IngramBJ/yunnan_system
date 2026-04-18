package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.entity.DistrictCode;
import com.yunnan.system.repository.DistrictCodeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/district-code")
public class DistrictCodeController {

    private final DistrictCodeRepository districtCodeRepository;

    public DistrictCodeController(DistrictCodeRepository districtCodeRepository) {
        this.districtCodeRepository = districtCodeRepository;
    }

    @GetMapping
    public ApiResponse<List<DistrictCode>> listAll() {
        return ApiResponse.ok(districtCodeRepository.findAll());
    }

    @PostMapping
    public ApiResponse<DistrictCode> create(@RequestBody DistrictCode districtCode) {
        return ApiResponse.ok(districtCodeRepository.save(districtCode));
    }

    @PutMapping("/{id}")
    public ApiResponse<DistrictCode> update(@PathVariable Long id, @RequestBody DistrictCode districtCode) {
        districtCode.setId(id);
        return ApiResponse.ok(districtCodeRepository.save(districtCode));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        districtCodeRepository.deleteById(id);
        return ApiResponse.ok("deleted", null);
    }
}