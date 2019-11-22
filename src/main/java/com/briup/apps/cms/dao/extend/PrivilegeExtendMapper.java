package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface PrivilegeExtendMapper {

    List<PrivilegeTree> selectPrivilegeTree();

    List<Privilege> selectByRoleId(long id);

    List<Privilege> selectByUserId(long id);
}
