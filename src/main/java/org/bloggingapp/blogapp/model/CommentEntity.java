package org.bloggingapp.blogapp.model;


import jakarta.persistence.*;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;

@Entity(name = "comments")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Nullable
    private String  title;

    @NonNull
    private String body;

    @CreatedDate
    private Date createAt;


    @ManyToOne
    @JoinColumn(name = "article_id",nullable = false)
    private ArticleEntity article;


    @ManyToOne
    @JoinColumn(name = "author_id",nullable = false)
    private UserEntity user;


}
