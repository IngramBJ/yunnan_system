package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.dto.NoticeSaveRequest;
import com.yunnan.system.entity.Notice;
import com.yunnan.system.service.NoticeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping
    public ApiResponse<Notice> create(@RequestBody @Valid NoticeSaveRequest request,
                                      @RequestParam Long publisherId,
                                      @RequestParam String publisherName) {
        return ApiResponse.ok(noticeService.create(request, publisherId, publisherName));
    }

    @PutMapping("/{id}")
    public ApiResponse<Notice> update(@PathVariable Long id, @RequestBody @Valid NoticeSaveRequest request) {
        return ApiResponse.ok(noticeService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        noticeService.delete(id);
        return ApiResponse.ok("deleted", null);
    }

    @GetMapping
    public ApiResponse<List<Notice>> listAll() {
        return ApiResponse.ok(noticeService.listAll());
    }

    @GetMapping("/{id}")
    public ApiResponse<Notice> getById(@PathVariable Long id) {
        return ApiResponse.ok(noticeService.getById(id));
    }
}