package com.yunnan.system.service.impl;

import com.yunnan.system.common.exception.BizException;
import com.yunnan.system.dto.LoginRequest;
import com.yunnan.system.dto.LoginResponse;
import com.yunnan.system.entity.User;
import com.yunnan.system.repository.UserRepository;
import com.yunnan.system.security.JwtUtil;
import com.yunnan.system.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BizException(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BizException(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误");
        }

        return new LoginResponse(
                jwtUtil.generateToken(user.getUsername()),
                user.getId(),
                user.getUsername(),
                user.getUserType().name()
        );
    }
}