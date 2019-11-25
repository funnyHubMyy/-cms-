package com.myy.apps.cms.service;

import com.myy.apps.cms.bean.Privilege;
import com.myy.apps.cms.utils.exception.CustomerException;
import com.myy.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface IPrivilegeService {

    //查询所有权限
    List<Privilege> findAll();

    //根据userId查询
    List<Privilege> findByUserId(long userId);

    //通过parentId查询
    List<Privilege> findByParentId(Long parentId);

    //保存或更新
    void saveOrUpdate(Privilege privilege) throws CustomerException;

    //查询树
    List<PrivilegeTree> findPrivilegeTree();

    //根据名字查询
    List<Privilege> findByName(String name);

    //根据ID删除权限
    void deleteById(long id);
}
