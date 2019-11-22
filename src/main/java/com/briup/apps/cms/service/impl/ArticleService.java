package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("articleService")
public class ArticleService implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {
        ArticleExample example = new ArticleExample();
        example.createCriteria();
        List<Article> articles = articleMapper.selectByExample(example);
        return articles;
    }

    @Override
    public void saveOrUpdate(Article article){
        if (article.getId()!=null){
            articleMapper.updateByPrimaryKey(article);
        }else {
            ArticleExample example = new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> articles = articleMapper.selectByExample(example);
            if (articles.size()>0){
                throw new CustomerException("平头哥书库不允许重复的标题");
            }
            article.setStatus(ArticleExtend.UNCHECKED);
            article.setPublishTime(System.currentTimeMillis());
            article.setReadTimes(0L);
            article.setThumbDown(0L);
            article.setThumbUp(0L);
            articleMapper.insert(article);
        }
    }

    @Override
    public void deleteById(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String, List<Article>> findArticlesOfCategory(Integer category_id, String name) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andCategoryIdEqualTo(category_id);
        List<Article> articles = articleMapper.selectByExample(example);
        Map<String,List<Article>> map = new HashMap<>();
        map.put(name,articles);
        return map;
    }

    @Override
    public Map<String,List<Article>> findArticlesOfAuthorById(long author_id,String name) {
        ArticleExample example = new ArticleExample();
        example.createCriteria().andAuthorIdEqualTo(author_id);
        List<Article> articles = articleMapper.selectByExample(example);
        Map<String,List<Article>> map = new HashMap<>();
        map.put(name,articles);
        return map;
    }

    @Override
    public List<ArticleExtend> findArticlesWithAuthorAndCategory() {
        List<ArticleExtend> articleExtends = articleExtendMapper.selectAll();
        return articleExtends;
    }

    @Override
    public ArticleExtend cascadeFindAll(long id) {
        ArticleExtend articleExtend = articleExtendMapper.selectById(id);
        return articleExtend;
    }


}
