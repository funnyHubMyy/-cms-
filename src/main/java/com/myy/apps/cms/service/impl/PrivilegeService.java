package com.myy.apps.cms.service.impl;

import com.myy.apps.cms.bean.Privilege;
import com.myy.apps.cms.bean.PrivilegeExample;
import com.myy.apps.cms.dao.PrivilegeMapper;
import com.myy.apps.cms.dao.extend.PrivilegeExtendMapper;
import com.myy.apps.cms.service.IPrivilegeService;
import com.myy.apps.cms.utils.exception.CustomerException;
import com.myy.apps.cms.vm.PrivilegeTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("privilegeService")
public class PrivilegeService implements IPrivilegeService {
    @Autowired
    private PrivilegeMapper privilegeMapper;
    @Autowired
    private PrivilegeExtendMapper privilegeExtendMapper;

    @Override
    public List<Privilege> findAll() {
        PrivilegeExample example = new PrivilegeExample();
        example.createCriteria();
        List<Privilege> privileges = privilegeMapper.selectByExample(example);
        return privileges;
    }

    @Override
    public List<Privilege> findByUserId(long userId) {
        return privilegeExtendMapper.selectByUserId(userId);
    }

    @Override
    public List<Privilege> findByParentId(Long parentId) {
        PrivilegeExample example = new PrivilegeExample();
        if (parentId==null) {
            example.createCriteria().andParentIdIsNull();
        }else{
        example.createCriteria().andParentIdEqualTo(parentId);
        }
        List<Privilege> privileges = privilegeMapper.selectByExample(example);
        return privileges;
    }


    @Override
    public void saveOrUpdate(Privilege privilege) throws CustomerException {
        if (privilege.getId()!=null) {
            privilegeMapper.updateByPrimaryKey(privilege);
        }else{
            List<Privilege> privileges = findByName(privilege.getName());
            if (privileges.size()>0) {
                throw new CustomerException("该权限已存在");
            }
            privilegeMapper.insert(privilege);
        }
    }

    @Override
    public List<PrivilegeTree> findPrivilegeTree() {
        List<PrivilegeTree> privilegeTrees = privilegeExtendMapper.selectPrivilegeTree();
        return privilegeTrees;
    }

    @Override
    public List<Privilege> findByName(String name) {
        PrivilegeExample example = new PrivilegeExample();
        example.createCriteria().andNameEqualTo(name);
        List<Privilege> privileges = privilegeMapper.selectByExample(example);
        return privileges;
    }

    @Override
    public void deleteById(long id) {
        PrivilegeExample example = new PrivilegeExample();
        example.createCriteria().andParentIdEqualTo(id);
        List<Privilege> privileges = privilegeMapper.selectByExample(example);
        if (privileges.size()>0) {
            throw new CustomerException("该权限含有次级权限，需要先删除次级权限");
        }
        privilegeMapper.deleteByPrimaryKey(id);
    }
}
