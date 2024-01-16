package com.example.demoapi.post.controller;

import com.example.demoapi.post.dto.PostRequestDto;
import com.example.demoapi.post.dto.PostResponseDto;
import com.example.demoapi.post.dto.PostUpdateDto;
import com.example.demoapi.post.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public void createPost(@RequestBody PostRequestDto postRequestDto){
        postService.createPost(postRequestDto);
    }

    @GetMapping("/posts/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId){
        return postService.getPost(postId);
    }

    @PutMapping("/posts/{postId}")
    public void updatePost(@PathVariable Long postId, @RequestBody PostUpdateDto postUpdateDto){
        postService.updatePost(postId, postUpdateDto);
    }
}
