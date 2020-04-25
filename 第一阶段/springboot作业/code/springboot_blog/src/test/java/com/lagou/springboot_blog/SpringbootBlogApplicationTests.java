package com.lagou.springboot_blog;

import com.lagou.pojo.Article;
import com.lagou.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootBlogApplicationTests {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void findAll() {
        List<Article> all = articleRepository.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }

}
