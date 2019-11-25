package com.myy.apps.cms.dao.extend;

import com.myy.apps.cms.bean.Privilege;
import com.myy.apps.cms.vm.PrivilegeTree;

import java.util.List;

public interface PrivilegeExtendMapper {

    List<PrivilegeTree> selectPrivilegeTree();

    List<Privilege> selectByRoleId(long id);

    List<Privilege> selectByUserId(long id);
}
