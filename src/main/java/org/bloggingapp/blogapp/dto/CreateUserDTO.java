package org.bloggingapp.blogapp.dto;


import lombok.Data;
import org.springframework.stereotype.Component;
import lombok.NonNull;

@Data
public class CreateUserDTO {

    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;

}
