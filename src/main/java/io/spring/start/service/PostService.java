package io.spring.start.service;

import io.spring.start.models.Post;

public interface PostService {
    Post findById(int id);
    String savePost(Post post);
}
