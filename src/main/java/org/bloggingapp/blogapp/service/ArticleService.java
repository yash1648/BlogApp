package org.bloggingapp.blogapp.service;

import org.bloggingapp.blogapp.dto.CreateArticleDTO;
import org.bloggingapp.blogapp.model.ArticleEntity;
import org.bloggingapp.blogapp.repository.ArticleRepository;
import org.bloggingapp.blogapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ArticleService {

     final ArticleRepository articleRepository;
    final UserRepository userRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public Iterable<ArticleEntity> getAllArticles(){
        return articleRepository.findAll();
    }

    public ArticleEntity getArticleBySlug(String slug){
        var article= articleRepository.findBySlug(slug);
        if (article==null)
            throw new ArticleNotFoundException(slug);
        else
            return article;

    }

    public ArticleEntity createArticle(CreateArticleDTO a, Long authorId){

        var author=userRepository.findById(authorId).orElseThrow(()->new UserService.UserNotFoundException(authorId));


        return articleRepository.save(ArticleEntity.builder()
                .title(a.getTitle())
                        .slug(a.getTitle().toLowerCase().replaceAll("\\s+","-"))
                .body(a.getBody())
                        .subtitle(a.getSubtitle())
                .author(author)
                .build());

    }

    public ArticleEntity updateArticle(Long articleId,CreateArticleDTO a){
        var article=articleRepository.findById(articleId).orElseThrow(()->new ArticleNotFoundException(articleId));
        if(a.getTitle()!=null)
        {
            article.setTitle(a.getTitle());
            article.setSlug(a.getTitle().toLowerCase().replaceAll("\\s+","-"));
        }

        if(a.getBody()!=null)
            article.setBody(a.getBody());
        if(a.getSubtitle()!=null)
            article.setSubtitle(a.getSubtitle());

        return articleRepository.save(article);

    }



    static class ArticleNotFoundException extends IllegalArgumentException{
        public ArticleNotFoundException(String slug){
            super("Article "+slug+ " not found");
        }
        public ArticleNotFoundException(Long id){
            super("Article id : "+id + " not found");
        }
    }

}