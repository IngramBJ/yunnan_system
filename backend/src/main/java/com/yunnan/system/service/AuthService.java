package com.yunnan.system.service;

import com.yunnan.system.dto.LoginRequest;
import com.yunnan.system.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}