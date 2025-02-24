package io.spring.start.service;

import io.spring.start.models.User;

import java.util.List;

public interface UserService {
User getUserById(int id);
String saveUser(User user);
String updateUser(User user,int id);
String deleteUser(int id);
List<User> getAllUsers();
User getUserByName(String name);
}
