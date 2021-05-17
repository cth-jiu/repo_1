package com.cc.mapper;

import com.cc.pojo.Article;
import com.cc.pojo.Comment;

import java.util.List;

public interface ArticleMapper {

    //搜索所有文章
    public List<Article> findAll();
}
