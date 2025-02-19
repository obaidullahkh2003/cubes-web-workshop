package io.spring.start.service;

import io.spring.start.models.Post;

import java.util.List;

public interface PostService {
    Post findById(int id);
    String savePost(Post post);
    List<Post> findByUser_Id(int userId);
}
