package org.bloggingapp.blogapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles/{article-slug}/comments")
public class CommentController {
    
    @GetMapping("")
    String getComments(){
        return "Comment";
    }

}
