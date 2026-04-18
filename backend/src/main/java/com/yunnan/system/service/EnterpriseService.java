package com.yunnan.system.service;

import com.yunnan.system.dto.EnterpriseSaveRequest;
import com.yunnan.system.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {
    Enterprise saveOrUpdate(Long id, EnterpriseSaveRequest request);
    Enterprise submitForReview(Long id);
    List<Enterprise> listAll();
    Enterprise getById(Long id);
}