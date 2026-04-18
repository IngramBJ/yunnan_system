package com.yunnan.system.controller;

import com.yunnan.system.common.ApiResponse;
import com.yunnan.system.dto.LoginRequest;
import com.yunnan.system.dto.LoginResponse;
import com.yunnan.system.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return ApiResponse.ok(authService.login(request));
    }
}