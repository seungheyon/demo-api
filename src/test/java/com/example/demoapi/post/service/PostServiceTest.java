package com.example.demoapi.post.service;

import com.example.demoapi.DemoApiApplication;
import com.example.demoapi.post.dto.PostRequestDto;
import com.example.demoapi.post.dto.PostUpdateDto;
import com.example.demoapi.post.entity.Post;
import com.example.demoapi.post.repository.PostRepository;
import com.example.demoapi.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@ContextConfiguration(classes = DemoApiApplication.class)
public class PostServiceTest {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceTest(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @DisplayName("sut는 postRequestDto 정보로 테이블에 post 를 생성한다.")
    @Test
    void createPostTest(){
        // Arrange
        var sut = new PostService(postRepository);
        String title = "testTitle";
        String contents = "testContents";
        var testDto = new PostRequestDto(title, contents);

        // Act
        Post actual = sut.createPost(testDto);

        // Assert
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getTitle()).isEqualTo(title);
        assertThat(actual.getContents()).isEqualTo(contents);
    }

    @DisplayName("sut는 postId에 해당하는 post의 정보로 구성된 postResponseDto 를 반환한다.")
    @Test
    void getPostTest(){
        // Arrange
        var sut = new PostService(postRepository);
        String title = "testTitle";
        String contents = "testContents";

        var createdPost = postRepository.save(new Post(null, title, contents));

        // Act
        var actual = sut.getPost(createdPost.getId());

        // Assert
        assertThat(actual.getTitle()).isEqualTo(title);
        assertThat(actual.getContents()).isEqualTo(contents);
    }

    @DisplayName("sut는 postId에 해당하는 post의 정보를 postUpadateDto 정보로 수정한다.")
    @Test
    @Transactional
    void updatePostTest(){
        // Arrange
        var sut = new PostService(postRepository);
        String title = "title";
        String contents = "contents";

        var createdPost = postRepository.save(new Post(null, title, contents));

        String newTitle = "newTitle";
        String newContents = "newContents";
        var testDto = new PostUpdateDto(newTitle, newContents);

        // Act
        sut.updatePost(createdPost.getId(), testDto);
        var actual = postRepository.findById(createdPost.getId()).get();

        // Assert
        assertThat(actual.getTitle()).isEqualTo("newtitle");
        assertThat(actual.getContents()).isEqualTo(newContents);
    }

}
