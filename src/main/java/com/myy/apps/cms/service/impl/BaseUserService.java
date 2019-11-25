package com.myy.apps.cms.service.impl;

import com.myy.apps.cms.bean.*;
import com.myy.apps.cms.bean.extend.UserExtend;
import com.myy.apps.cms.dao.UserMapper;
import com.myy.apps.cms.dao.UserRoleMapper;
import com.myy.apps.cms.dao.extend.UserExtendMapper;
import com.myy.apps.cms.service.IBaseUserService;
import com.myy.apps.cms.utils.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("baseUserService")
public class BaseUserService implements IBaseUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExtendMapper userExtendMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<User> findAll() {
        UserExample example = new UserExample();
        example.createCriteria();
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public List<UserExtend> cascadeFindAll() {
        List<UserExtend> userExtends = userExtendMapper.selectAll();
        return userExtends;
    }

    @Override
    public void saveOrUpdate(User user) throws CustomerException {
        if(user.getTelephone().matches("\\^d{11}")){
            throw new CustomerException("电话号码为11位数字");
        }
        if(user.getId()!=null){
            userMapper.updateByPrimaryKey(user);
        }else{
            userMapper.insert(user);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException{
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void setRoles(long id, List<Long> new_roleIds) throws CustomerException{
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        List<UserRole> userRoles = userRoleMapper.selectByExample(example);
        List<Long> old_roleIds = new ArrayList<>();
        for (UserRole ur:userRoles) {
            old_roleIds.add(ur.getRoleId());
        }
        for (Long oldId:
             old_roleIds) {
            if (!new_roleIds.contains(oldId)) {
                example.clear();
                example.createCriteria()
                        .andUserIdEqualTo(id)
                        .andRoleIdEqualTo(oldId);
                userRoleMapper.deleteByExample(example);
            }
        }
        for (Long newId :
                new_roleIds) {
            if (!old_roleIds.contains(newId)) {
                UserRole userRole = new UserRole();
                userRole.setUserId(id);
                userRole.setRoleId(newId);
                userRoleMapper.insert(userRole);
            }
        }
    }
}
