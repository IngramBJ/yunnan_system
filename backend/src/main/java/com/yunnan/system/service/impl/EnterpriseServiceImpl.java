package com.yunnan.system.service.impl;

import com.yunnan.system.common.exception.BizException;
import com.yunnan.system.dto.EnterpriseSaveRequest;
import com.yunnan.system.entity.Enterprise;
import com.yunnan.system.entity.enums.EnterpriseStatus;
import com.yunnan.system.repository.EnterpriseRepository;
import com.yunnan.system.service.EnterpriseService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public Enterprise saveOrUpdate(Long id, EnterpriseSaveRequest request) {
        Enterprise enterprise = id == null ? new Enterprise() :
                enterpriseRepository.findById(id)
                        .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "企业不存在"));

        enterprise.setOrgCode(request.getOrgCode());
        enterprise.setEnterpriseName(request.getEnterpriseName());
        enterprise.setEnterpriseNature(request.getEnterpriseNature());
        enterprise.setIndustry(request.getIndustry());
        enterprise.setBusinessScope(request.getBusinessScope());
        enterprise.setContactPerson(request.getContactPerson());
        enterprise.setAddress(request.getAddress());
        enterprise.setPostalCode(request.getPostalCode());
        enterprise.setPhone(request.getPhone());
        enterprise.setFax(request.getFax());
        enterprise.setEmail(request.getEmail());
        enterprise.setDistrictCode(request.getDistrictCode());
        enterprise.setDistrictName(request.getDistrictName());
        enterprise.setUpdatedAt(LocalDateTime.now());
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise submitForReview(Long id) {
        Enterprise enterprise = enterpriseRepository.findById(id)
                .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "企业不存在"));
        enterprise.setStatus(EnterpriseStatus.PENDING_REVIEW);
        enterprise.setUpdatedAt(LocalDateTime.now());
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public List<Enterprise> listAll() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Enterprise getById(Long id) {
        return enterpriseRepository.findById(id)
                .orElseThrow(() -> new BizException(HttpStatus.NOT_FOUND.value(), "企业不存在"));
    }
}