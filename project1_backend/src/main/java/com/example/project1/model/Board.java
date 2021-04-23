package com.example.project1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Board {
    private String title;
    private String author;
    private String content;
}
