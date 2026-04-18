package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.entity.ReasonDict;
import com.yunnan.system.repository.ReasonDictRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reason-dict")
public class ReasonDictController {

    private final ReasonDictRepository reasonDictRepository;

    public ReasonDictController(ReasonDictRepository reasonDictRepository) {
        this.reasonDictRepository = reasonDictRepository;
    }

    @GetMapping
    public ApiResponse<List<ReasonDict>> listAll() {
        return ApiResponse.ok(reasonDictRepository.findAll());
    }

    @PostMapping
    public ApiResponse<ReasonDict> create(@RequestBody ReasonDict reasonDict) {
        return ApiResponse.ok(reasonDictRepository.save(reasonDict));
    }

    @PutMapping("/{id}")
    public ApiResponse<ReasonDict> update(@PathVariable Long id, @RequestBody ReasonDict reasonDict) {
        reasonDict.setId(id);
        return ApiResponse.ok(reasonDictRepository.save(reasonDict));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        reasonDictRepository.deleteById(id);
        return ApiResponse.ok("deleted", null);
    }
}