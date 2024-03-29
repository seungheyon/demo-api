package com.example.demoapi.post.entity;

import com.example.demoapi.post.dto.PostUpdateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    private String contents;

    public void update(PostUpdateDto postUpdateDto){
        this.title = postUpdateDto.getTitle();
        this.contents = postUpdateDto.getContents();
    }
}
