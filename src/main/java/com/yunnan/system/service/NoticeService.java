package com.yunnan.system.service;

import com.yunnan.system.dto.NoticeSaveRequest;
import com.yunnan.system.entity.Notice;

import java.util.List;

public interface NoticeService {
    Notice create(NoticeSaveRequest request, Long publisherId, String publisherName);
    Notice update(Long id, NoticeSaveRequest request);
    void delete(Long id);
    List<Notice> listAll();
    Notice getById(Long id);
}