package com.zhfan.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhfan.blog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper  extends BaseMapper<Tag> {

    List<Tag> findTagsByArticleId(long articleId);
}
