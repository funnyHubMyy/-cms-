package com.myy.apps.cms.web.controller;

import com.myy.apps.cms.bean.Role;
import com.myy.apps.cms.bean.extend.RoleExtend;
import com.myy.apps.cms.service.IRoleService;
import com.myy.apps.cms.utils.Message;
import com.myy.apps.cms.utils.MessageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:9527",
        methods = {RequestMethod.GET,RequestMethod.POST},
        maxAge = 3600)
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @ApiOperation("查询所有角色")
    @GetMapping("findAll")
    public Message findAll(){
        List<Role> roles = roleService.findAll();
        return MessageUtils.success(roles);
    }

    @ApiOperation(value = "级联查询所有",notes = "级联角色")
    @GetMapping("cascadePrivilegeFindAll")
    public Message cascadePrivilegeFindAll(){
        List<RoleExtend> roleExtends = roleService.cascadeFindAll();
        return MessageUtils.success(roleExtends);
    }

    @ApiOperation("添加或更新")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Role role){
        roleService.saveOrUpdateRole(role);
        return MessageUtils.success("更新成功");
    }

    @ApiOperation("根据ID删除角色")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        roleService.deleteById(id);
        return MessageUtils.success("删除成功");
    }

    @ApiOperation("为角色授权")
    @PostMapping("authorization")
    public Message authorization(long id, Long[] privileges){
        List<Long> ids = Arrays.asList(privileges);
        roleService.authorization(id,ids);
        return MessageUtils.success("授权成功");
    }

}
