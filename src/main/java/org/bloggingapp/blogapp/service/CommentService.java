package org.bloggingapp.blogapp.service;

import org.bloggingapp.blogapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }


}
