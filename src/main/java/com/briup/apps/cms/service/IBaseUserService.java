package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.utils.exception.CustomerException;

import java.util.List;

public interface IBaseUserService {

    //查询所有用户
    List<User> findAll();

    //查询所有用户，级联角色
    List<UserExtend> cascadeFindAll();

    //保存或更新用户基本信息
    void saveOrUpdate(User user) throws CustomerException;

    //根据ID删除用户
    void deleteById(long id);

    //设置权限
    void setRoles(long id, List<Long> new_roleIds);
}
