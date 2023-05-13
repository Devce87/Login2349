package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.entity.User;
import com.example.RegisterLogin.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService<User>{

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean save(User entity) {
        String encodedPassword = new BCryptPasswordEncoder().encode(entity.getPassword());

        User user = User.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .password(encodedPassword)
                .build();

        userRepo.save(user);
        return true;
    }
}
