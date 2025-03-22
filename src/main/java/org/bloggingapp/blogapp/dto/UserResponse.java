package org.bloggingapp.blogapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;

      private String username;

     private String email;

    private String bio;

    private String image;
}
