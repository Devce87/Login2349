package com.example.RegisterLogin.security;

import com.example.RegisterLogin.entity.User;
import com.example.RegisterLogin.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    public UserDetailServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepo
                .findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("The user with email "+ email +" does not exist"));

        return new UserDetailsImpl(user);
    }
}
