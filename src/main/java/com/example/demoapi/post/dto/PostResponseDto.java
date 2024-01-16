package com.example.demoapi.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private String title;
    private String contents;
}
