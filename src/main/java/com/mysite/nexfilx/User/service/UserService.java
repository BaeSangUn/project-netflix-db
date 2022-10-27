package com.mysite.nexfilx.User.service;

import com.mysite.nexfilx.User.dao.UserRepository;
import com.mysite.nexfilx.User.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User join(String useremail,  String password) {
        User user = User.builder()
                .useremail(useremail)
                .password(passwordEncoder.encode(password))
                .build();

        userRepository.save(user);
        return user;


    }
}