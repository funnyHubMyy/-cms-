package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;
import com.briup.apps.cms.bean.User;

import java.util.List;

public class ArticleExtend extends Article {

    public static final String UNCHECKED="未审核";
    public static final String CHECKED="已审核";
    public static final String PASS="审核通过";

    private Category category;

    private User Author;

    private List<Comment> comments;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User author) {
        Author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
