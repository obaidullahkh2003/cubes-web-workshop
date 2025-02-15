package io.spring.start.service.impl;

import io.spring.start.exception.ResourceNotFoundException;
import io.spring.start.models.User;
import io.spring.start.repo.UserRepo;
import io.spring.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserById(int id) {
        User person = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
        return person;
    }

    @Override
    public String saveUser(User user) {
        userRepo.save(user);
        return "User saved";
    }

    @Override
    public String updateUser(User user, int id) {
        User person = userRepo.findById(id).orElseThrow(null);

        person.setName(user.getName());
        person.setEmail(user.getEmail());
        person.setPassword(user.getPassword());
        person.setBio(user.getBio());
        person.setFollowers(user.getFollowers());
        person.setFollowing(user.getFollowing());
        person.setPostnum(user.getPostnum());

        userRepo.save(person);

        return "user updated sucsessfuly";
    }

    @Override
    public String deleteUser(int id) {
        userRepo.deleteById(id);
        return "user deleted";
    }

    @Override
    public List<User> getAllUsers() {
        List<User> persons = userRepo.findAll();
        return persons;
    }
}
