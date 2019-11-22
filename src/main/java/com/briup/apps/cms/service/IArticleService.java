package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.exception.CustomerException;

import java.util.List;
import java.util.Map;

public interface IArticleService {

    //查询所有文章，但不做级联查询
    List<Article> findAll();
    //编辑、发布文章（作者）
    void saveOrUpdate(Article article) throws CustomerException;
    //删除文章（管理员，作者）
    void deleteById(Long id);
    //查找指定栏目的所有文章
    Map<String,List<Article>> findArticlesOfCategory(Integer category_id,String name);
    //查找指定作者的所有文章（普通用户，管理员，作者）
    Map<String,List<Article>> findArticlesOfAuthorById(long author_id, String name);
    //查找所有文章并级联作者和栏目
    List<ArticleExtend> findArticlesWithAuthorAndCategory();
    //查找指定文章并级联评论（普通用户，管理员，作者）
    ArticleExtend cascadeFindAll(long id);


}
