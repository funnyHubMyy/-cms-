package com.myy.apps.cms.bean.extend;

import com.myy.apps.cms.bean.Privilege;
import com.myy.apps.cms.bean.Role;

import java.util.List;

public class RoleExtend extends Role {
    private List<Privilege> privileges;

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
