package com.myy.apps.cms.web.controller;

import com.myy.apps.cms.bean.User;
import com.myy.apps.cms.bean.extend.UserExtend;
import com.myy.apps.cms.service.IUserService;
import com.myy.apps.cms.utils.JwtTokenUtil;
import com.myy.apps.cms.utils.Message;
import com.myy.apps.cms.utils.MessageUtils;
import com.myy.apps.cms.vm.UserVm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Validated
@RestController
@Api(value = "登录、注册模块")
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:9527",
        methods = {RequestMethod.GET,RequestMethod.POST},
        maxAge = 3600)
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public Message login(@RequestBody UserVm userVm){
        // 1. 认证用户的用户名和密码
        // 2. 如果登录成功产生token,将token缓存起来，返回
        // 3. 如果登录失败
        UserExtend userExtend = userService
                .findByNameAndPassword(userVm.getUsername(),userVm.getPassword());
        String token = JwtTokenUtil.createJWT(userExtend.getId(),userExtend.getUsername());
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return MessageUtils.success(map,"登录成功");
    }

    @ApiOperation(value = "通过token获取用户信息")
    @GetMapping("info")
    public Message info(String token){
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        long id = Long.parseLong(JwtTokenUtil.getUserId(token,JwtTokenUtil.base64Secret));
        UserExtend userExtend = userService.findById(id);
        return MessageUtils.success(userExtend);
    }

    @PostMapping("logout")
    public Message logout(){
        // 1. 登出， token从缓存中移除掉
        return MessageUtils.success("退出成功");
    }

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "register")
    public String register(User user){
        System.out.println(user);
        userService.saveOrUpdate(user);
        return "保存成功！";
    }

    @GetMapping(value = "deleteByName")
    public String deleteByName(String name){
        userService.deleteByName(name);
        return "删除成功！";
    }
}
