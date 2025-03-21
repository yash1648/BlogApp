package org.bloggingapp.blogapp.repository;

import org.bloggingapp.blogapp.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {
}
