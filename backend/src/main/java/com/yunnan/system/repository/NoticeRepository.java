package com.yunnan.system.repository;

import com.yunnan.system.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findByOrderByPublishedAtDesc();
}