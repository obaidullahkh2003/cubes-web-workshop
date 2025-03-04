package io.spring.start.service.impl;

import io.spring.start.exception.ResourceNotFoundException;
import io.spring.start.models.User;
import io.spring.start.repo.UserRepo;
import io.spring.start.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepo userRepo;
    @Value("${user.profile.image.path}")
    private String uploadDir;
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
    public String saveUser(User user, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            String contentType = file.getContentType();
            String originalFilename = file.getOriginalFilename();

            if (contentType == null || (!contentType.equals("image/png") && !contentType.equals("image/jpeg") && !contentType.equals("image/webp"))) {
                return "Error: Only PNG and JPG images are allowed!";
            }

            if (!originalFilename.endsWith(".png") && !originalFilename.endsWith(".jpg") && !originalFilename.endsWith(".jpeg")&& !originalFilename.endsWith(".webp")) {
                return "Error: Invalid file extension! Only .png and .jpg files are allowed.";
            }

            try {
                String fileName = System.currentTimeMillis() + "_" + originalFilename;
                Path filePath = Path.of(uploadDir, fileName);

                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                user.setProfile_image("/assets/" + fileName);
            } catch (IOException e) {
                return "Error uploading image: " + e.getMessage();
            }
        }

        userRepo.save(user);
        return "User saved successfully!";
    }

    @Override
    public String updateUser(User user, int id) {
        User person = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));

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

    @Override
    public User getUserByName(String name) {
        User user=userRepo.getUserByName(name);
        return user;
    }
}
