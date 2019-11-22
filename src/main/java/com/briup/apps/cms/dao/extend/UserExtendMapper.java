package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.extend.UserExtend;

import java.util.List;

public interface UserExtendMapper {

    UserExtend selectById(long id);

    UserExtend selectByNameAndPassword(String name, String password);

    List<UserExtend> selectAll();
}
