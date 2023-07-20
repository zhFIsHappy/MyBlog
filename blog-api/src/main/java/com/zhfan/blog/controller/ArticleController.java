package com.zhfan.blog.controller;
import com.zhfan.blog.service.ArticleService;
import com.zhfan.blog.vo.Result;
import com.zhfan.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// interact with json
@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams){
        System.out.println("3");
        return articleService.listArticle(pageParams);
    }
}
