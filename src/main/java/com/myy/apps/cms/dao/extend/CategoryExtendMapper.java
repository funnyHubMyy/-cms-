package com.myy.apps.cms.dao.extend;

import com.myy.apps.cms.bean.extend.CategoryExtend;

import java.util.List;

public interface CategoryExtendMapper {

    List<CategoryExtend> selectCategoryHierarchic();

}
