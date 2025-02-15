package io.spring.start.controllers;

import io.spring.start.models.Post;
import io.spring.start.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable int id) {
        Post post=postService.findById(id);
        return post;
        // /post/1 id =1
        // /post/10 id 10
    }

    @PostMapping("/post/create")
    public String createPost(@RequestBody Post post) {
        return postService.savePost(post);
    }

}
