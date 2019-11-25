package com.myy.apps.cms.dao.extend;

import com.myy.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

public interface ArticleExtendMapper {

    List<ArticleExtend> selectAll();

    ArticleExtend selectById(long id);

}
