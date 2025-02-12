package io.spring.start.service;

import io.spring.start.models.User;

public interface UserService {
    User getUser(int id);
    String saveUser(User user);
}
