package org.bloggingapp.blogapp.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity(name = "articles")
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Protected no-arg constructor
@AllArgsConstructor  // Generates a constructor with all fields
@Builder  // Enables builder pattern (optional)
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String title;

    @Column(unique = true)
    private String slug;

    private String subtitle;

    private String body;

    @CreatedDate
    private Date createAt;

    @ManyToOne
    @JoinColumn(name="author_id",nullable = false)
    private UserEntity author;
}
