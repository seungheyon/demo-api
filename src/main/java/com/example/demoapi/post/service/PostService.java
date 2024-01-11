package com.example.demoapi.post.service;

import com.example.demoapi.post.dto.PostRequestDto;
import com.example.demoapi.post.entity.Post;
import com.example.demoapi.post.repository.PostRepository;
import org.springframework.stereotype.Service;

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

}
