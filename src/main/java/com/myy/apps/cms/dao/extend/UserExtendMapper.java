package com.myy.apps.cms.dao.extend;

import com.myy.apps.cms.bean.extend.UserExtend;

import java.util.List;

public interface UserExtendMapper {

    UserExtend selectById(long id);

    UserExtend selectByNameAndPassword(String name, String password);

    List<UserExtend> selectAll();
}
