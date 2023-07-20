package com.zhfan.blog.vo;

import com.zhfan.blog.dao.pojo.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class ArticleVo {

    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;
    /**
     * 创建时间
     */
    private String createDate;

    private SysUser author ;

//    private ArticleBodyVo body;

    private List<TagVo> tags;

//    private CategoryVo category;

}
