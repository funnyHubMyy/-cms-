package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.extend.RolePrivilegeExtend;

import java.util.List;


public interface RolePrivilegeExtendMapper {

    List<RolePrivilegeExtend> selectAll();

}
