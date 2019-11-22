package com.briup.apps.cms.web.controller;


import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.extend.UserExtend;
import com.briup.apps.cms.service.IBaseUserService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtils;
import com.briup.apps.cms.vm.UserRoleVm;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController()
@RequestMapping("/baseUser")
@CrossOrigin(origins = "http://localhost:9527",
        methods = {RequestMethod.GET,RequestMethod.POST},
        maxAge = 3600)
public class BaseUserController {
    @Autowired
    private IBaseUserService baseUserService;

    @ApiOperation("查询所有用户")
    @GetMapping("findAll")
    public Message findAll(){
        List<User> user = baseUserService.findAll();
        return MessageUtils.success(user);
    }

    @ApiOperation(value = "级联查询所有用户",notes = "级联角色")
    @GetMapping("cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<UserExtend> userExtends = baseUserService.cascadeFindAll();
        return MessageUtils.success(userExtends);
    }

    @ApiOperation("保存或修改")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(User user){
        baseUserService.saveOrUpdate(user);
        return MessageUtils.success("更新成功");
    }

    @ApiOperation("根据ID删除")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        baseUserService.deleteById(id);
        return MessageUtils.success("删除成功");
    }

    @ApiOperation("设置权限")
    @PostMapping("setRoles")
    public Message setRoles(UserRoleVm userRoleVm){
        long id = userRoleVm.getId();
        List<Long> new_RoleIds = userRoleVm.getRoles();
        baseUserService.setRoles(id,new_RoleIds);
        return MessageUtils.success("操作成功");
    }
}
