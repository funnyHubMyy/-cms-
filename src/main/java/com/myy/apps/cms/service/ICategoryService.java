package com.myy.apps.cms.service;

import com.myy.apps.cms.bean.Category;
import com.myy.apps.cms.utils.exception.CustomerException;

import java.util.List;

public interface ICategoryService {

    //查询所有栏目
    List<Category> findAll();
    //添加、修改栏目（管理员）
    void saveOrUpdate(Category category)throws CustomerException;
    //删除栏目（管理员）
    void deleteById(int id)throws CustomerException;
    //批量删除
    void batchDelete(int[] ids)throws CustomerException;

}
