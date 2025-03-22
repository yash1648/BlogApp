package org.bloggingapp.blogapp.dto;


import lombok.*;

@Data
public class CreateArticleDTO {
    @NonNull
    private String title;
    @NonNull
    private String body;

    private String subtitle;
}
