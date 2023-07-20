package com.zhfan.blog.service;

import com.zhfan.blog.vo.Result;
import com.zhfan.blog.vo.params.PageParams;

public interface ArticleService {
    Result listArticle(PageParams pageParams);
}
