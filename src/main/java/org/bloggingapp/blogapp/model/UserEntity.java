package org.bloggingapp.blogapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // Required for JPA
@AllArgsConstructor  // Required for @Builder to work properly
@ToString
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    private String bio;

    private String image;
}
