package com.zhfan.blog.controller;

import com.zhfan.blog.service.TagService;
import com.zhfan.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// tags/hot
@RequestMapping("tags")
public class TagsController {
    @Autowired
    private TagService tagService;
    @GetMapping("hot")
    public Result hot(){
        // check the hottest  6 tags
        int limit = 6;
        return  tagService.hots(limit);
    }
}
