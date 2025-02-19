package io.spring.start.service.impl;

import io.spring.start.models.Post;
import io.spring.start.repo.PostRepo;
import io.spring.start.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post findById(int id) {
        Post savedpost=postRepo.findById(id).orElseThrow(null);
        return savedpost;
    }

    @Override
    public String savePost(Post post) {
        postRepo.save(post);
        return "Post saved";
    }

    @Override
    public List<Post> findByUser_Id(int userId) {
        List<Post> posts=postRepo.findByUserId(userId);
        return posts;
    }


}
