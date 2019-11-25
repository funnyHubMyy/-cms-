package com.myy.apps.cms.service.impl;

import com.myy.apps.cms.bean.Category;
import com.myy.apps.cms.bean.CategoryExample;
import com.myy.apps.cms.dao.CategoryMapper;
import com.myy.apps.cms.dao.extend.CategoryExtendMapper;
import com.myy.apps.cms.service.ICategoryService;
import com.myy.apps.cms.utils.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("categoryService")
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<Category> findAll() {
        CategoryExample example = new CategoryExample();
        example.createCriteria();
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    @Override
    public void saveOrUpdate(Category category) {
        if(category.getId()!=null){
            categoryMapper.updateByPrimaryKey(category);
        }else{
            CategoryExample example = new CategoryExample();
            example.createCriteria().andNameEqualTo(category.getName());
            List<Category> categories = categoryMapper.selectByExample(example);
            if (categories.size()>0){
                throw new CustomerException("该栏目已存在！");
            }
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteById(int id) throws CustomerException {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if (category==null){
            throw new CustomerException("要删除的栏目不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public void batchDelete(int[] ids) throws CustomerException {
        for (Integer id:ids) {
            deleteById(id);
        }
    }

}
