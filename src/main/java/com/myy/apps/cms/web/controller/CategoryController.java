package com.myy.apps.cms.web.controller;

import com.myy.apps.cms.bean.Category;
import com.myy.apps.cms.service.ICategoryService;
import com.myy.apps.cms.utils.Message;
import com.myy.apps.cms.utils.MessageUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:9527",
        methods = {RequestMethod.GET,RequestMethod.POST},
        maxAge = 3600)
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @ApiOperation(value = "添加或更新栏目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "主键",paramType = "form"),
            @ApiImplicitParam(name = "name",value = "栏目名称",paramType = "form",required = true),
            @ApiImplicitParam(name = "description",value = "栏目描述",paramType = "form",required = true),
            @ApiImplicitParam(name = "no",value = "序号",paramType = "form"),
            @ApiImplicitParam(name = "parentId",value = "父栏目ID",paramType = "form"),
    })
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(
            Integer id,
            @NotNull String name,
            @NotNull String description,
            Integer no,
            Integer parentId
    ){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setDescription(description);
        category.setNo(no);
        category.setParentId(parentId);
        categoryService.saveOrUpdate(category);
        return MessageUtils.success("更新成功");
    }

    @ApiOperation(value = "根据ID删除栏目")
    @ApiImplicitParam(name = "id",value = "主键",paramType = "query")
    @GetMapping(value = "deleteById")
    public Message deleteById(int id){
        categoryService.deleteById(id);
        return MessageUtils.success("删除成功！");

    }

    @ApiOperation(value = "批量删除")
    @PostMapping(value = "batchDelete")
    public Message batchDelete(int[] ids){
        return null;
    }

    @ApiOperation(value = "查询所有栏目")
    @GetMapping(value = "findAll")
    public Message findAll(){
        return MessageUtils.success(categoryService.findAll());
    }
}
