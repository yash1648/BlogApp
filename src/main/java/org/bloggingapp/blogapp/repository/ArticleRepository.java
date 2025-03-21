package org.bloggingapp.blogapp.repository;

import org.bloggingapp.blogapp.model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {
}
