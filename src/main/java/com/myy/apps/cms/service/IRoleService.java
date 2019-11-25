package com.myy.apps.cms.service;


import com.myy.apps.cms.bean.Role;
import com.myy.apps.cms.bean.extend.RoleExtend;
import com.myy.apps.cms.utils.exception.CustomerException;

import java.util.List;

public interface IRoleService {

    //查询所有角色
    List<Role> findAll();

    //查询所有角色，级联权限
    List<RoleExtend> cascadeFindAll();

    //根据角色名称查询角色
    List<Role> findRoleByName(String name);

    //添加或更新角色
    void saveOrUpdateRole(Role role) throws CustomerException;

    //根据ID删除角色
    void deleteById(long id) throws CustomerException;

    //为角色授权
    void authorization(long id,List<Long> new_privilegeIds) throws CustomerException;

}
