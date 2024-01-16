package com.example.demoapi.post.service;

import com.example.demoapi.post.dto.PostRequestDto;
import com.example.demoapi.post.dto.PostResponseDto;
import com.example.demoapi.post.dto.PostUpdateDto;
import com.example.demoapi.post.entity.Post;
import com.example.demoapi.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(PostRequestDto postRequestDto){
        return postRepository.save(Post.builder()
                .title(postRequestDto.getTitle())
                .contents(postRequestDto.getContents())
                .build());
    }

    public PostResponseDto getPost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow();
        return PostResponseDto.builder()
                .title(post.getTitle())
                .contents(post.getContents())
                .build();
    }

    @Transactional
    public void updatePost(Long postId, PostUpdateDto postUpdateDto){
        Post post = postRepository.findById(postId).orElseThrow();
        post.update(postUpdateDto);
    }

}
