package io.spring.start.controllers;

import io.spring.start.models.Post;
import io.spring.start.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String createPost(@Valid @RequestBody Post post) {
        return postService.savePost(post);
    }

    @GetMapping("/user/{id}/posts")
    public List<Post> findByUser_Id(@PathVariable int id) {

        List<Post> posts=postService.findByUser_Id(id);
        return posts;
    }

}
