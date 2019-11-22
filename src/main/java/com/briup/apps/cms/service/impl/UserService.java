package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserExample;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.dao.UserMapper;
import com.briup.apps.cms.dao.extend.UserExtendMapper;
import com.briup.apps.cms.service.IUserService;
import com.briup.apps.cms.utils.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Resource
    private UserExtendMapper userExtendMapper;

    @Override
    public List<User> findAll() {
        UserExample example = new UserExample();
        example.createCriteria();
        List<User> users = userMapper.selectByExample(example);
        users.forEach(user -> System.out.println(user));
        return users;
    }

    @Override
    public void saveOrUpdate(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andUserFaceNotEqualTo(name);
        userMapper.deleteByExample(example);
    }

    @Override
    public UserExtend findById(long id) {
        return userExtendMapper.selectById(id);
    }

    @Override
    public UserExtend findByNameAndPassword(String name, String password)
            throws CustomerException {
        UserExtend userExtend = userExtendMapper.selectByNameAndPassword(name,password);
        if(userExtend==null){
            throw new CustomerException("用户名或密码错误");
        }
        return userExtend;
    }


}
