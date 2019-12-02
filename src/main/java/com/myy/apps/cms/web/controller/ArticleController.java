package com.myy.apps.cms.web.controller;

import com.myy.apps.cms.bean.Article;
import com.myy.apps.cms.bean.extend.ArticleExtend;
import com.myy.apps.cms.service.IArticleService;
import com.myy.apps.cms.utils.Message;
import com.myy.apps.cms.utils.MessageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


@Validated
@RestController
@Api(value = "文章管理模块")
@RequestMapping("/article")
@CrossOrigin(origins = "http://localhost:9527",
        methods = {RequestMethod.GET,RequestMethod.POST},
        maxAge=3600)
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @ApiOperation(value = "查询所有文章")
    @GetMapping("findAll")
    public Message findAll(){
        List<Article> articles = articleService.findAll();
       Message<Article> message =  MessageUtils.success(articles);
        return  message;
    }

    @ApiOperation(value = "级联查询文章",notes = "级联所属栏目、作者")
    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll(){
        List<ArticleExtend> articles
                = articleService.findArticlesWithAuthorAndCategory();
        return MessageUtils.success(articles);
    }

    //查找指定文章及评论
    @ApiOperation(value = "根据ID级联查询文章",notes = "级联评论")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "主键",paramType = "query")
    )
    @GetMapping("findArticleCascadeComment")
    public Message findArticleCascadeComment(long id){
        ArticleExtend articleExtend = articleService.cascadeFindAll(id);
        return MessageUtils.success(articleExtend);
    }

    //查找指定栏目下的所有文章
    @ApiOperation(value = "根据栏目ID查询文章")
    @ApiImplicitParam(name = "id",value = "主键",paramType = "query")
    @GetMapping("findArticlesInCascade")
    public Message findArticlesInCascade(){
        List<ArticleExtend> articlesOfCategoryById = articleService.findArticlesWithAuthorAndCategory();
        return MessageUtils.success(articlesOfCategoryById);
    }

    //查找指定作者的所有文章
    @ApiOperation(value = "根据作者ID、姓名查询文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "author_id",value = "主键",paramType = "query"),
            @ApiImplicitParam(name = "name",value = "姓名",paramType = "query")
    }
    )
    @GetMapping("findArticlesOfAuthor")
    public Message findArticlesOfAuthor(long author_id,String name){
        Map<String,List<Article>> map = articleService.findArticlesOfAuthorById(author_id,name);
        return MessageUtils.success(map);
    }



    @ApiOperation(value = "保存或更新文章",
            notes = "如果参数中包含ID后端认为是更新操作，如果参数中不包含id认为是插入操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",paramType = "form"),
            @ApiImplicitParam(name = "title",value = "标题",paramType = "form",required = true),
            @ApiImplicitParam(name = "content",value = "内容",paramType = "form",required = true),
            @ApiImplicitParam(name = "source",value = "源内容",paramType = "form"),
            @ApiImplicitParam(name = "categoryId",value = "所属栏目ID",paramType = "form",required = true),
            @ApiImplicitParam(name = "authorId",value = "所属作者ID",paramType = "form")
    })
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(
            Long id,
            @NotNull String title,
            @NotNull String content,
            String source,
            @NotNull Integer categoryId,
            Long authorId
    ){
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(1L);
        System.out.println(article);
        articleService.saveOrUpdate(article);
        Message message = MessageUtils.success("更新成功！");
        return message;
    }

    @ApiOperation(value = "根据ID删除文章")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "id",value = "主键",paramType = "query")
    )
    @GetMapping("deleteById")
    public Message deleteById(Long id){
        articleService.deleteById(id);
        Message message = MessageUtils.success("删除成功！");
        return message;
    }


}
