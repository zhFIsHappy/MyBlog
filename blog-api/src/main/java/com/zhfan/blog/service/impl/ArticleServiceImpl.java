package com.zhfan.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhfan.blog.dao.mapper.ArticleMapper;
import com.zhfan.blog.dao.pojo.Article;
import com.zhfan.blog.service.ArticleService;
//import org.springframework.stereotype.Service;
import com.zhfan.blog.service.SysUserService;
import com.zhfan.blog.service.TagService;
import com.zhfan.blog.vo.ArticleVo;
import com.zhfan.blog.vo.Result;
import com.zhfan.blog.vo.params.PageParams;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
//@Data
public class ArticleServiceImpl implements ArticleService {
    @Autowired

    private ArticleMapper articleMapper;
    @Autowired
    private TagService tagService;

    @Autowired
    private SysUserService sysUserService;
    @Override
    public Result listArticle(PageParams pageParams) {

        // 29 maybe wrong
        Page<Article> page  = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

//        queryWrapper.orderByDesc();
//        queryWrapper.orderByDesc(Article::getWeight, Article::getCreateDate);

        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);
        List<Article> records = articlePage.getRecords();
        List<ArticleVo> articleVoList = copyList(records, true, true );
        return Result.success(articleVoList);
    }

    private List<ArticleVo> copyList(List<Article> records, boolean isTag, boolean isAuthor) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for(Article record : records){
            articleVoList.add(copy(record, isTag, isAuthor));
        }

         return articleVoList;
    }
    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor ){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article,articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if(isTag) {
            Long articleId = article.getId();
            articleVo.setTags(tagService.findTagsByArticleId(articleId));
        }
        if(isAuthor) {
            Long authorId = article.getAuthorId();
//            sysUserService.
            articleVo.setAuthor(sysUserService.findUserById(authorId));
        }
        return articleVo;
    }


}
