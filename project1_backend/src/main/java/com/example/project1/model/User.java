package com.example.project1.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class User {
    private String email;
    private String name;
    private String password;
}
