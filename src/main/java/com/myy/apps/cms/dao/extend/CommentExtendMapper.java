package com.myy.apps.cms.dao.extend;

import com.myy.apps.cms.bean.Comment;

public interface CommentExtendMapper {

    Comment selectByArticleId(long id);

}
