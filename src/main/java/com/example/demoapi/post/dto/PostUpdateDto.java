package com.example.demoapi.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostUpdateDto {
    private String title;
    private String contents;
}
