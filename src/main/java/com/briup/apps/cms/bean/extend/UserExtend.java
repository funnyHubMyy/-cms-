package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Role;
import com.briup.apps.cms.bean.User;
import com.briup.apps.cms.bean.UserRole;

import java.util.List;


public class UserExtend extends User {
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
