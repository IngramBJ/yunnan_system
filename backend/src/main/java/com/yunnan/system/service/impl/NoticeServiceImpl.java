package com.yunnan.system.service.impl;

import com.yunnan.system.common.exception.BizException;
import com.yunnan.system.dto.NoticeSaveRequest;
import com.yunnan.system.entity.Notice;
import com.yunnan.system.repository.NoticeRepository;
import com.yunnan.system.service.NoticeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public Notice create(NoticeSaveRequest request, Long publisherId, String publisherName) {
        Notice notice = new Notice();
        notice.setTitle(request.getTitle());
        notice.setContent(request.getContent());
        notice.setPublisherId(publisherId);
        notice.setPublisherName(publisherName);
        notice.setPublishedAt(LocalDateTime.now());
        return noticeRepository.save(notice);
    }

    @Override
    public Notice update(Long id, NoticeSaveRequest request) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "通知不存在"));
        notice.setTitle(request.getTitle());
        notice.setContent(request.getContent());
        return noticeRepository.save(notice);
    }

    @Override
    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }

    @Override
    public List<Notice> listAll() {
        return noticeRepository.findByOrderByPublishedAtDesc();
    }

    @Override
    public Notice getById(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "通知不存在"));
    }
}