package com.yunnan.system.repository;

import com.yunnan.system.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    Optional<Enterprise> findByOrgCode(String orgCode);
    List<Enterprise> findByDistrictCode(String districtCode);
}