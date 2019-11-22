package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Privilege;
import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.RolePrivilege;

public class RolePrivilegeExtend extends RolePrivilege {

    private Role role;
    private Privilege privilege;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}
