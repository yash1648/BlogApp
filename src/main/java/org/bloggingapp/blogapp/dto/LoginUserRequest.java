package org.bloggingapp.blogapp.dto;


import lombok.Data;
import lombok.NonNull;

@Data

public class LoginUserRequest {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
