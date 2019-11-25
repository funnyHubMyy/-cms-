package com.myy.apps.cms.service;

import com.myy.apps.cms.bean.User;
import com.myy.apps.cms.bean.extend.UserExtend;
import com.myy.apps.cms.utils.exception.CustomerException;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    void saveOrUpdate(User user);

    void deleteByName(String name);

    UserExtend findById(long id);

    UserExtend findByNameAndPassword(String name,String password) throws CustomerException;

}
