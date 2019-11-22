package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Comment;

public interface CommentExtendMapper {

    Comment selectByArticleId(long id);

}
