package com.lagou.service;

import com.lagou.pojo.Article;
import com.lagou.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public Page<Article> findAllArticle(Integer pageIndex,Integer pageNum){

        PageRequest pageOf = PageRequest.of(pageIndex, pageNum);
        Page<Article> all = articleRepository.findAll(pageOf);
        return all;
    }
}
