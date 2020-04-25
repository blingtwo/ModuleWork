package com.lagou.controller;

import com.lagou.pojo.Article;
import com.lagou.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/index")
    public String toIndexPage(HttpServletRequest request, Model model, Integer pageIndex){
        if (pageIndex == null) {
            pageIndex =1;
        }
        Integer pageNum = 2;
        Page<Article> allArticle = articleService.findAllArticle(pageIndex-1,pageNum);

        model.addAttribute("allArticle",allArticle);
        return "index";
    }
}
