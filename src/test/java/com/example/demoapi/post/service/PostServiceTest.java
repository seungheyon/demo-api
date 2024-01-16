package com.example.demoapi.post.service;

import com.example.demoapi.DemoApiApplication;
import com.example.demoapi.post.dto.PostRequestDto;
import com.example.demoapi.post.entity.Post;
import com.example.demoapi.post.repository.PostRepository;
import com.example.demoapi.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@ContextConfiguration(classes = DemoApiApplication.class)
public class PostServiceTest {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceTest(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @DisplayName("글 제목과 내용이 주어지면 테이블에 글이 추가된다.")
    @Test
    void createPostTest(){
        // Arrange commitTest
        PostService sut = new PostService(postRepository);
        String testTitle = "testTitle";
        String testContents = "testContents";
        var testDto = new PostRequestDto(testTitle, testContents);

        // Act
        Post actual = sut.createPost(testDto);

        // Assert
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getTitle()).isEqualTo(testTitle);
        assertThat(actual.getContents()).isEqualTo(testContents);
    }

}
