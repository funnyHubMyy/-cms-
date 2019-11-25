package com.myy.apps.cms.dao.extend;

import com.myy.apps.cms.bean.Role;
import com.myy.apps.cms.bean.extend.RoleExtend;

import java.util.List;

public interface RoleExtendMapper {

    Role selectByUserId(long id);

    List<RoleExtend> selectAllRolesWithPrivilege();

}
