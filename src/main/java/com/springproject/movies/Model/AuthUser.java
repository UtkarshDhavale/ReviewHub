package com.springproject.movies.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthUser {
    @Id
    private Object id;
    private String username;
    private String name;
    private String password;
    private String roles;
}
