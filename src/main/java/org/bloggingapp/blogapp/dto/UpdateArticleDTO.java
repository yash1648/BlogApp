package org.bloggingapp.blogapp.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class UpdateArticleDTO {
    @NonNull
    private String title;
    @NonNull
    private String body;
    private String subtitle;
}
