package com.yunnan.system.config;

import com.yunnan.system.entity.User;
import com.yunnan.system.entity.enums.UserType;
import com.yunnan.system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        userRepository.findByUsername("admin").orElseGet(() -> {
            User user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("admin123"));
            user.setUserType(UserType.PROVINCE);
            user.setRealName("系统管理员");
            user.setDistrictCode("530000");
            user.setDistrictName("云南省");
            user.setEnabled(true);
            return userRepository.save(user);
        });
    }
}