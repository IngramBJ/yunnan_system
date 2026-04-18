package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.entity.Role;
import com.yunnan.system.repository.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping
    public ApiResponse<List<Role>> listAll() {
        return ApiResponse.ok(roleRepository.findAll());
    }

    @PostMapping
    public ApiResponse<Role> create(@RequestBody @Valid Role role) {
        return ApiResponse.ok(roleRepository.save(role));
    }

    @PutMapping("/{id}")
    public ApiResponse<Role> update(@PathVariable Long id, @RequestBody @Valid Role role) {
        role.setId(id);
        return ApiResponse.ok(roleRepository.save(role));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        roleRepository.deleteById(id);
        return ApiResponse.ok("deleted", null);
    }
}