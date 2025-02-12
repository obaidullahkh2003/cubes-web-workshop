package io.spring.start.service.impl;

import io.spring.start.models.User;
import io.spring.start.repo.UserRepo;
import io.spring.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Override
    public User getUser(int id) {
        User user =userRepo.findById(id).orElseThrow(null);
        return user;
    }

    @Override
    public String saveUser(User user) {
        userRepo.save(user);
        return "user created successfully";
    }
}
