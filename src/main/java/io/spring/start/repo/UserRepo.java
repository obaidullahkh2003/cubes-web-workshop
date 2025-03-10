package io.spring.start.repo;

import io.spring.start.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User getUserByName(String name);
}// select * from user where name like ??
