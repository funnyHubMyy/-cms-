package com.myy.apps.cms.web.controller;

import com.myy.apps.cms.bean.Privilege;
import com.myy.apps.cms.service.IPrivilegeService;
import com.myy.apps.cms.utils.Message;
import com.myy.apps.cms.utils.MessageUtils;
import com.myy.apps.cms.vm.PrivilegeTree;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/privilege")
@CrossOrigin(origins = "http://localhost:9527",
        methods = {RequestMethod.GET,RequestMethod.POST},
        maxAge = 3600)
public class PrivilegeController {
    @Autowired
    private IPrivilegeService privilegeService;

    @ApiOperation("查询所有")
    @GetMapping("findAll")
    public Message findAll(){
        List<Privilege> privileges = privilegeService.findAll();
        return MessageUtils.success(privileges);
    }

    @ApiOperation("通过parentId查询")
    @GetMapping("findByParentId")
    public Message findByParentId(Long id){
        List<Privilege> privileges = privilegeService.findByParentId(id);
        return MessageUtils.success(privileges);
    }

    @ApiOperation("添加或更新")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Privilege privilege){
        privilegeService.saveOrUpdate(privilege);
        return MessageUtils.success("更新成功");
    }

    @ApiOperation("删除权限")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        privilegeService.deleteById(id);
        return MessageUtils.success("删除成功");
    }

    @ApiOperation("查询树")
    @GetMapping("findPrivilegeTree")
    public Message findPrivilegeTree(){
        List<PrivilegeTree> privilegeTree = privilegeService.findPrivilegeTree();
        return MessageUtils.success(privilegeTree);
    }

}
