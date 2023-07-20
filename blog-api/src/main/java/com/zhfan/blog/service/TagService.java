package com.zhfan.blog.service;

import com.zhfan.blog.vo.Result;
import com.zhfan.blog.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(long articleId);

    Result hots(int limit);
}
