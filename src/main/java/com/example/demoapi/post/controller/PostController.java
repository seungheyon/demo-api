package com.example.demoapi.post.controller;

import com.example.demoapi.post.dto.PostRequestDto;
import com.example.demoapi.post.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public void createPost(@RequestBody PostRequestDto postRequestDto){
        postService.createPost(postRequestDto);
    }
}
