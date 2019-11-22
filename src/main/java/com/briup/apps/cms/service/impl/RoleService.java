package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.RoleExample;
import com.briup.apps.cms.bean.RolePrivilege;
import com.briup.apps.cms.bean.RolePrivilegeExample;
import com.briup.apps.cms.bean.extend.RoleExtend;
import com.briup.apps.cms.dao.RoleMapper;
import com.briup.apps.cms.dao.RolePrivilegeMapper;
import com.briup.apps.cms.dao.extend.RoleExtendMapper;
import com.briup.apps.cms.service.IRoleService;
import com.briup.apps.cms.utils.exception.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleService implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleExtendMapper roleExtendMapper;
    @Autowired
    private RolePrivilegeMapper rolePrivilegeMapper;

    @Override
    public List<Role> findAll() {
        RoleExample example = new RoleExample();
        example.createCriteria();
        List<Role> roles = roleMapper.selectByExample(example);
        return roles;
    }

    @Override
    public List<RoleExtend> cascadeFindAll() {
        List<RoleExtend> roleExtends = roleExtendMapper.selectAllRolesWithPrivilege();
        return roleExtends;
    }

    @Override
    public List<Role> findRoleByName(String name) {
        RoleExample example = new RoleExample();
        example.createCriteria().andNameEqualTo(name);
        List<Role> roles = roleMapper.selectByExample(example);
        return roles;
    }


    @Override
    public void saveOrUpdateRole(Role role) throws CustomerException {
        if (role.getId()!=null){
            roleMapper.updateByPrimaryKey(role);
        }else{
        List<Role> roles = findRoleByName(role.getName());
        if (roles.size()>0) {
            throw new CustomerException("该角色已存在");
        }
        roleMapper.insert(role);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void authorization(long id,List<Long> new_privilegeIds) throws CustomerException {
        RolePrivilegeExample example = new RolePrivilegeExample();
        example.createCriteria().andRoleIdEqualTo(id);
        List<RolePrivilege> privileges = rolePrivilegeMapper.selectByExample(example);
        List<Long> old_privilegeIds = new ArrayList<>();
        for (RolePrivilege rp:privileges) {
            old_privilegeIds.add(rp.getPrivilegeId());
        }
        for (Long newId:new_privilegeIds) {
            if (!old_privilegeIds.contains(newId)) {
            RolePrivilege rolePrivilege = new RolePrivilege();
            rolePrivilege.setRoleId(id);
            rolePrivilege.setPrivilegeId(newId);
            rolePrivilegeMapper.insert(rolePrivilege);
            }
        }
        for (Long oldId:old_privilegeIds) {
            if (!new_privilegeIds.contains(oldId)) {
                example.clear();
                example.createCriteria()
                        .andPrivilegeIdEqualTo(oldId)
                        .andRoleIdEqualTo(id);
                rolePrivilegeMapper.deleteByExample(example);
            }
        }

    }
}
