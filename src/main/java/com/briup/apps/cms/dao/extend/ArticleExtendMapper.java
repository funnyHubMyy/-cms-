package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.extend.ArticleExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleExtendMapper {

    List<ArticleExtend> selectAll();

    ArticleExtend selectById(long id);

}
