package com.learn.jwt.models;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String userId;

    private String name;

    private String email;
}
