package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.extend.CategoryExtend;

import java.util.List;
import java.util.Map;

public interface CategoryExtendMapper {

    List<CategoryExtend> selectCategoryHierarchic();

}
